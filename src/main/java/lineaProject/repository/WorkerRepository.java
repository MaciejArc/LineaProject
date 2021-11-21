package lineaProject.repository;

import lineaProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<User, Long> {
}
