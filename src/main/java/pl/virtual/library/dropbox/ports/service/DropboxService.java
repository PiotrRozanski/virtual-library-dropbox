package pl.virtual.library.dropbox.ports.service;

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

    public DropboxService(LibraryRepository repository, DropboxOperation operation, EbooksListMapper mapper) {
        this.repository = repository;
        this.operation = operation;
        this.mapper = mapper;
    }

    public void saveAllEbooks() {
        final List<Ebook> ebooksList;

        EbooksListMapper mapper = new EbooksListMapper();
        ebooksList = mapper.mapToEbooksList(operation.getEbookMetadata());

        repository.save(ebooksList);
    }
}
