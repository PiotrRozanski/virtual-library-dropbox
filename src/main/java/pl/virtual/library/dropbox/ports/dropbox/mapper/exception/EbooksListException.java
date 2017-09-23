package pl.virtual.library.dropbox.ports.dropbox.mapper.exception;

public class EbooksListException extends IllegalArgumentException {

    public EbooksListException(String message) {
        super(message);
    }

    public EbooksListException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
