package pl.michalzadrozny.resterrors.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michalzadrozny.resterrors.model.book.Book;
import pl.michalzadrozny.resterrors.repository.book.BookRepo;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepo bookRepo;

    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) throws NotFoundException {
        Book book = bookRepo.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
