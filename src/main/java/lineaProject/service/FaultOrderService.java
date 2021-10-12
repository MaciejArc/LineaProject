package lineaProject.service;

import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.repository.FaultOrderRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FaultOrderService {

    private final FaultOrderRepository faultOrderRepository;

    public FaultOrderService(FaultOrderRepository faultOrderRepository) {
        this.faultOrderRepository = faultOrderRepository;
    }

    public Boolean faultOrderVerification(User user, Long id){
        return faultOrderRepository.existsByClientAndId(user,id);

    }

    public FaultOrder findFaultOrederByClientId(Long id){
        return faultOrderRepository.findFaultOrderByClientId(id);
    }
}
