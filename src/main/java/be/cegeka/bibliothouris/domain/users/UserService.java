package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String firstName, String lastName, long insz, String city, String street, int doorNumber, int postalCode){
        userRepository.addUser(new User(counter.incrementAndGet() ,  firstName,  lastName,  insz,  city,  street,  doorNumber,  postalCode));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
