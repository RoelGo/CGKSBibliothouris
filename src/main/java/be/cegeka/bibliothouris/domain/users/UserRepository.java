package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) throws ValidationException {
        boolean isUnique = true;
        String errorMessage = "";
        for (User user1 : users) {
            isUnique = !user1.getInsz().equals(user.getInsz());
        }
        if (!isUnique){
         errorMessage += "INSZ is not unique";
        }
        if (user.getLastName().isEmpty()){
            errorMessage += " Please fill in last name";
        }
        if (user.getCity().isEmpty()){
            errorMessage += " Please fill in city";
        }
        if (user.getInsz().isEmpty()){
            errorMessage += " Please fill in INSZ";
        }

        if (errorMessage.isEmpty()) {
            users.add(user);
        }else {
            throw new ValidationException(errorMessage);
        }
    }
}
