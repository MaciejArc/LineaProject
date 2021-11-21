package lineaProject.service;

import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.repository.FaultOrderRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WorkerService {

    private final FaultOrderRepository faultOrderRepository;

    public WorkerService(FaultOrderRepository faultOrderRepository) {
        this.faultOrderRepository = faultOrderRepository;
    }

    public List<FaultOrder> findFaultOrderByUserAndStatus(User user, String status){
        return faultOrderRepository.findFaultOrdersByUserAndStatus(user,status);
    }
}
