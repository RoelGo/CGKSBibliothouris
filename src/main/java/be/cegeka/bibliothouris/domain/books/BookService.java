package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davids on 25/01/2017.
 */
@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;


    public void addBook(String title, String ISBN, String firstName, String lastName) {
        bookRepository.addBook(new Book(title, ISBN, firstName, lastName));
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }


    public List<Book> searchBook(String searchInput) {
        List<Book> searchList = bookRepository.getAllBooks();
        List<Book> hitList = new ArrayList<>();
        for (Book book : searchList) {
            if (isbnIsEqual(book, searchInput) || authorFirstNameIsEqual(book, searchInput) || authorLastNameIsEqual(book, searchInput)) {
                hitList.add(book);
            }
        }
        if (hitList.size() < 1) {
            System.out.println("No matches found");
        }
        return hitList;
    }

    protected boolean isbnIsEqual(Book book, String searchInput) {
        return book.getISBN().equals(searchInput);
    }

    protected boolean authorFirstNameIsEqual(Book book, String searchInput) {
        return book.getAuthorFirstName().equals(searchInput);
    }

    protected boolean authorLastNameIsEqual(Book book, String searchInput) {
        return book.getAuthorLastName().equals(searchInput);
    }
}
