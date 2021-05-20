package pl.michalzadrozny.resterrors.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalzadrozny.resterrors.model.book.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
