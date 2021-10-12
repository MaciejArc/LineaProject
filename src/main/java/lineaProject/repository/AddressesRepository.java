package lineaProject.repository;

import lineaProject.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Addresses,Long> {


    List<Addresses> findAddressesByUserId(Long id);
}
