package pl.virtual.library.dropbox.ports.dropbox.exception;

public class DropboxConnectionException extends IllegalArgumentException {

    public DropboxConnectionException(String message) {
        super(message);
    }

    public DropboxConnectionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
