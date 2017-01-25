package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by davids on 25/01/2017.
 */
@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;


    public void addBook(String title, long ISBN) {
        bookRepository.addBook(new Book(title, ISBN));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

}
