package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.ws.rs.Path;
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
    void addUser(@RequestParam(value = "first name") String firstName,
                 @RequestParam(value = "last name") String lastName,
                 @RequestParam(value = "INSZ") String insz,
                 @RequestParam(value = "city") String city,
                 @RequestParam(value = "street") String street,
                 @RequestParam(value = "door number") String doorNumber,
                 @RequestParam(value = "postal code") String postalCode) {
        try {
            userService.addUser(firstName, lastName, insz, city, street, doorNumber, postalCode);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }


}
