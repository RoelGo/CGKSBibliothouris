package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String firstName,
                        String lastName,
                        String insz,
                        String city,
                        String street,
                        String doorNumber,
                        String postalCode) throws ValidationException {

        userRepository.addUser(new User(counter.incrementAndGet(), firstName, lastName, insz, city, street, doorNumber, postalCode));

    }


    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
