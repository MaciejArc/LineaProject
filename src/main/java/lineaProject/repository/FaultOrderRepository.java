package lineaProject.repository;

import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultOrderRepository extends JpaRepository<FaultOrder,Long> {

    Boolean existsByClientAndId(User user, Long id);

    List<FaultOrder> findFaultOrdersByClientId(Long id);

    List<FaultOrder> findFaultOrdersByUserAndStatus(User user,String status);


}
