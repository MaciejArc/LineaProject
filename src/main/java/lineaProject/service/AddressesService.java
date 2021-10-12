package lineaProject.service;

import lineaProject.entity.Addresses;
import lineaProject.entity.User;
import lineaProject.repository.AddressesRepository;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class AddressesService {
    private final AddressesRepository addressesRepository;

    public AddressesService(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    public Addresses addNewAddress(Addresses addresses, User user){
        addresses.setUser(user);
        return addressesRepository.save(addresses);
    }
    public List<Addresses> findAddressesById(Long id){
        return addressesRepository.findAddressesByUserId(id);
    }
}
