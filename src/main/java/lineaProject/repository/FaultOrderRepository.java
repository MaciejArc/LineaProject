package lineaProject.repository;

import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultOrderRepository extends JpaRepository<FaultOrder,Long> {

    Boolean existsByClientAndId(User user, Long id);

    FaultOrder findFaultOrderByClientId(Long id);
}
