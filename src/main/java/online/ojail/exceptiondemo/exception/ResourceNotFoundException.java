package online.ojail.exceptiondemo.exception;

public class ResourceNotFoundException extends RuntimeException{
    private final String message;

    public ResourceNotFoundException(Object resource) {
        String resourceName = resource.toString();
        int i = resourceName.lastIndexOf('.') + 1;
        this.message = String.format("Resource: {%s} Not Fount.", resourceName.substring(i));
    }

    @Override
    public String getMessage() {
        return message;
    }

}
