package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/search/{isbn}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity getBooksByISBN(@PathVariable("isbn") String ISBN) {
        try {
            return new ResponseEntity<>(bookService.searchStringByIsbn(ISBN), HttpStatus.ACCEPTED);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/search/{author}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity getBooksByauthor(@PathVariable("author") String author) {
        try {
            return new ResponseEntity<>(bookService.searchStringByAuthor(author), HttpStatus.ACCEPTED);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/search/{title}", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity getBooksBytitle(@PathVariable("title") String title) {
        try {
            return new ResponseEntity<>(bookService.searchStringByIsbn(title), HttpStatus.ACCEPTED);
        } catch (ValidationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


}