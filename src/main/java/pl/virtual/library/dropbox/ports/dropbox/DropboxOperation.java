package pl.virtual.library.dropbox.ports.dropbox;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import org.springframework.stereotype.Component;
import pl.virtual.library.dropbox.ports.dropbox.exception.DropboxConnectionException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class DropboxOperation {

    private final DbxClientV2 client;

    public DropboxOperation() {
        client = new ConnectionToDropbox().getClient();
    }

    public ListFolderResult getEbookMetadata() {
        try {
            return client.files().listFolder("");
        } catch (DbxException exception) {
            throw new DropboxConnectionException("No found path to folder", exception);
        }
    }

    public DbxDownloader<FileMetadata> getEbook(final String pathToFile) {
        try {
            return client.files().download(pathToFile);
        } catch (DbxException exception) {
            throw new DropboxConnectionException("No found file with \"" + pathToFile + "\" path", exception);
        }
    }
}
