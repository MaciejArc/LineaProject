package lineaProject.service;

import lineaProject.entity.Addresses;
import lineaProject.entity.FaultOrder;
import lineaProject.entity.User;
import lineaProject.repository.FaultOrderRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FaultOrderService {

    private final FaultOrderRepository faultOrderRepository;

    public FaultOrderService(FaultOrderRepository faultOrderRepository) {
        this.faultOrderRepository = faultOrderRepository;
    }

    public Boolean faultOrderVerification(User user, Long id){
        return faultOrderRepository.existsByClientAndId(user,id);

    }

    public FaultOrder findFaultOrderById(Long id){
        return faultOrderRepository.findById(id).get();
    }

    public List<FaultOrder> findAllFaultOrderByClientId(Long id){
        return faultOrderRepository.findFaultOrdersByClientId(id);
    }

    public FaultOrder addNewFaultOrder(FaultOrder faultOrder, User user){
       faultOrder.setClient(user);
        return faultOrderRepository.save(faultOrder);

    }
    public FaultOrder editFaultOrder(FaultOrder faultOrder, User user, Addresses addresses, String description){
        faultOrder.setClient(user);
        faultOrder.setDescription(description);
        faultOrder.setAddress(addresses);
        return faultOrderRepository.save(faultOrder);
    }

}
