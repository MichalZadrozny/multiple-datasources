package pl.michalzadrozny.resterrors.dao.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalzadrozny.resterrors.model.book.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
