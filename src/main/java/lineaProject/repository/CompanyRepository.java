package lineaProject.repository;

import lineaProject.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company , Long> {

}
