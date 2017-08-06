package pl.virtual.library.dropbox.ports.repository.jpa;


import org.springframework.data.mongodb.repository.MongoRepository;
import pl.virtual.library.dropbox.application.command.Ebook;

public interface LibraryRepository extends MongoRepository<Ebook, String> {
}
