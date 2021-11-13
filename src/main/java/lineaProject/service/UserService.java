package lineaProject.service;

import lineaProject.entity.User;
import lineaProject.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean emailExist(String email) {
        return userRepository.existsUserByEmail(email);
    }

    public User registryNewAccount(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public List<User> findAllWorkers(){
        return userRepository.findUsersByRole("ROLE_WORKER");
    }

    public List<User> findAllAdmins(){return userRepository.findUsersByRole("ROLE_ADMIN");}

    public User findById (String id){return userRepository.findById(Long.parseLong(id)).get();}

    public User registryNewWorker(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_WORKER");
        return userRepository.save(user);
    }
    public User editWorker(User user, User editUser){
        editUser.setRole("ROLE_WORKER");
        editUser.setPassword(user.getPassword());
        return userRepository.save(editUser);
    }
}
