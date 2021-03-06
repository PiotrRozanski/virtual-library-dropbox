package pl.virtual.library.dropbox.ports.service;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.v2.files.FileMetadata;
import org.springframework.stereotype.Component;
import pl.virtual.library.dropbox.application.command.Ebook;
import pl.virtual.library.dropbox.ports.dropbox.DropboxOperation;
import pl.virtual.library.dropbox.ports.dropbox.mapper.EbooksListMapper;
import pl.virtual.library.dropbox.ports.repository.jpa.LibraryRepository;

import java.util.List;

@Component
public class DropboxService {

    private LibraryRepository repository;
    private DropboxOperation operation;
    private EbooksListMapper mapper;

    public DropboxService(final LibraryRepository repository,
                          final DropboxOperation operation,
                          final EbooksListMapper mapper) {
        this.repository = repository;
        this.operation = operation;
        this.mapper = mapper;
    }

    public void downloadAllEbooks() {
        final List<Ebook> ebooksList = mapper.mapToEbooksList(operation.getEbookMetadata());

        repository.save(ebooksList);
    }

    public DbxDownloader<FileMetadata> downloadEbook(final String pathToFile) {
        return operation.getEbook(pathToFile);
    }
}
