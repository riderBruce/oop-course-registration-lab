package infra;

public class FileHandlerException extends RuntimeException {

    public FileHandlerException(String message) {
        super(message);
    }

    public FileHandlerException(String message, Throwable cause) {
        super(message, cause);
    }
}
