package ds.leadgateway.common.exception;

import ds.leadgateway.common.message.GlobalMessage;

public class ResourceNotFoundException extends BaseException {
    
    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(GlobalMessage.NOT_FOUND.getMessage(), GlobalMessage.NOT_FOUND.getCode(), 
              String.format("Resource '%s' with identifier '%s' not found", resourceName, identifier));
    }
    
    public ResourceNotFoundException(String message) {
        super(message, GlobalMessage.NOT_FOUND.getCode(), message);
    }
}
