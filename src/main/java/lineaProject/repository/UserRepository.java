package lineaProject.repository;

import lineaProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsUserByEmail(String email);

    User findUserByEmail(String email);

}
