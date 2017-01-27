package be.cegeka.bibliothouris.application;


import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import be.cegeka.bibliothouris.domain.rental.Rental;
import be.cegeka.bibliothouris.domain.rental.RentalService;
import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.List;
/**
 * Created by roelg on 25/01/2017.
 */
@Controller
@RequestMapping("/rental")
public class RentalController {
    @Inject
    private RentalService rentalService;
    private UserService userService;
    private BookService bookService;

    @RequestMapping(value = "/getRentals", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Rental> getRentals() {
        return rentalService.getAllRentals();
    }

    @RequestMapping(value ="/addRental", method = RequestMethod.POST)
    public
    @ResponseBody
    void addRental(@RequestParam(value = "book") Book book,
                   @RequestParam(value = "user") User user,
                   @RequestParam(value = "due date")LocalDate dueDate){
        try {
            rentalService.addRental(book,user,dueDate);
        }catch (ValidationException e){
            e.printStackTrace();
        }

    }
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public
    @ResponseBody
    void returnBook(@RequestParam(value = "rental") Rental rental){
        try {
        rentalService.returnBook(rental);
    }catch (ValidationException e){
            e.printStackTrace();
        }
}}
