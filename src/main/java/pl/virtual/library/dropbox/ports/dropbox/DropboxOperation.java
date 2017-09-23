package pl.virtual.library.dropbox.ports.dropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import org.springframework.stereotype.Component;
import pl.virtual.library.dropbox.ports.dropbox.exception.DropboxConnectionException;

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
            exception.printStackTrace();
        }
        throw new DropboxConnectionException("No found path to folder");
    }
}
