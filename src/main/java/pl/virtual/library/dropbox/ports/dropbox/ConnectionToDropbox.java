package pl.virtual.library.dropbox.ports.dropbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

//Todo Usprawnic sposob dodawania tokenu dla usera
public class ConnectionToDropbox {

    private static final String ACCESS_TOKEN = "1mgZ6niMQBMAAAAAAAAHaCculeMF2wlKcBB1Vt0txjDTu8L_sa5gvM6IcCmmhq4R";

    private DbxRequestConfig config;
    private DbxClientV2 client;

    public ConnectionToDropbox() {
        client = prepareConnection();
    }

    private DbxClientV2 prepareConnection() {
        config = new DbxRequestConfig("Piotr Piotr", "pl_PL");
        return new DbxClientV2(config, ACCESS_TOKEN);
    }

    public DbxClientV2 getClient() {
        return client;
    }
}
