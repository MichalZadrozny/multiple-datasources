package pl.michalzadrozny.resterrors.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.michalzadrozny.resterrors.model.user.AppUser;

@Repository
public interface UserRepo extends JpaRepository<AppUser, Long> {
}
