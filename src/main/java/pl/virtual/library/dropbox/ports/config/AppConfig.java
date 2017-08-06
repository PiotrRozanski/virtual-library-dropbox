package pl.virtual.library.dropbox.ports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.virtual.library.dropbox.ports.dropbox.DropboxOperation;

@Configuration
public class AppConfig {

    @Bean
    public DropboxOperation dropboxOperation() {
        return new DropboxOperation();
    }

}
