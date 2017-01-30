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

        boolean isUnique = true;
        String errorMessage = "";
        for (User user1 : userRepository.getAllUsers()) {
            isUnique = !user1.getInsz().equals(insz);
        }
        if (!isUnique) {
            errorMessage += "INSZ is not unique";
        }
        if (lastName.isEmpty()) {
            errorMessage += " Please fill in last name";
        }
        if (city.isEmpty()) {
            errorMessage += " Please fill in city";
        }
        if (insz.isEmpty()) {
            errorMessage += " Please fill in INSZ";
        }

        if (errorMessage.isEmpty()) {
            userRepository.addUser(new User(counter.incrementAndGet(), firstName, lastName, insz, city, street, doorNumber, postalCode));
        } else {
            throw new ValidationException(errorMessage);
        }
    }


    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
