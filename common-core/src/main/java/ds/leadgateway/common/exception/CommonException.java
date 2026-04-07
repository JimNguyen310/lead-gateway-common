package ds.leadgateway.common.exception;

import ds.leadgateway.common.message.IMessage;

public class CommonException extends BaseException {
    public CommonException(IMessage iMessage) {
        super(iMessage.getMessage(), iMessage.getCode(), null);
    }
}
