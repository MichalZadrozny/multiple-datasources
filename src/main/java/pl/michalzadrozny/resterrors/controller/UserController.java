package pl.michalzadrozny.resterrors.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.michalzadrozny.resterrors.repository.user.UserRepo;
import pl.michalzadrozny.resterrors.model.user.AppUser;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable long id) throws NotFoundException {
        AppUser user = userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
