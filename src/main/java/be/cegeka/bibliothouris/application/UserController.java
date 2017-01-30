package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addUser(@RequestParam(value = "first name", required = false) String firstName,
                 @RequestParam(value = "last name") String lastName,
                 @RequestParam(value = "INSZ") String insz,
                 @RequestParam(value = "city") String city,
                 @RequestParam(value = "street", required = false) String street,
                 @RequestParam(value = "door number", required = false) String doorNumber,
                 @RequestParam(value = "postal code", required = false) String postalCode) {
        try {
            userService.addUser(firstName, lastName, insz, city, street, doorNumber, postalCode);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


}
