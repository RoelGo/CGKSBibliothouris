package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.xml.bind.ValidationException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Inject
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addBook(@RequestParam(value = "title") String title,
                 @RequestParam(value = "ISBN") String ISBN,
                 @RequestParam(value = "authorFirstName",required = false) String firstName,
                 @RequestParam(value = "authorLastName") String lastName) {
        try {
            bookService.addBook(title, ISBN, firstName, lastName);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

}