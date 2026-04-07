package ds.leadgateway.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ds.leadgateway.common.exception.BaseException;
import ds.leadgateway.common.message.GlobalMessage;
import ds.leadgateway.common.message.IMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    @JsonProperty("code")
    private String code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    @JsonProperty("detail")
    private String detailError;

    public BaseResponse() {
    }

    public BaseResponse(String code, String message, T data, String detailError) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.detailError = detailError;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public String getDetailError() {
        return detailError;
    }

    public boolean hasError() {
        return !GlobalMessage.SUCCESS.getCode().equalsIgnoreCase(this.code);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new Builder<T>()
                .code(GlobalMessage.SUCCESS.getCode())
                .message(GlobalMessage.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> failure(IMessage message, String... detail) {
        String detailMsg = (detail != null && detail.length > 0) ? detail[0] : null;
        return new Builder<T>()
                .code(message.getCode())
                .message(message.getMessage())
                .detailError(detailMsg)
                .build();
    }

    public static <T> BaseResponse<T> failure(BaseException exception) {
        return new Builder<T>()
                .code(exception.getCode())
                .message(exception.getMessage())
                .detailError(exception.getDetail())
                .build();
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private String code;
        private String message;
        private T data;
        private String detailError;

        public Builder<T> code(String code) {
            this.code = code;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Builder<T> detailError(String detailError) {
            this.detailError = detailError;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<>(code, message, data, detailError);
        }
    }
}
