package pl.michalzadrozny.resterrors.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michalzadrozny.resterrors.model.book.Author;
import pl.michalzadrozny.resterrors.repository.book.AuthorRepo;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorRepo authorRepo;

    @Autowired
    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getBook(@PathVariable long id) throws NotFoundException {
        Author author = authorRepo.findById(id).orElseThrow(() -> new NotFoundException("Author not found"));
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }
}
