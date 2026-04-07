package ds.leadgateway.common.dto;

import java.util.List;

public record SessionUser(String id, String username, List<String> authorities) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String username;
        private List<String> authorities;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder authorities(List<String> authorities) {
            this.authorities = authorities;
            return this;
        }

        public SessionUser build() {
            return new SessionUser(id, username, authorities);
        }
    }
}
