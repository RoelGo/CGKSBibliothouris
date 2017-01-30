package be.cegeka.bibliothouris.domain.rental;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.books.BookRepository;
import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by roelg on 25/01/2017.
 */
@Named
public class RentalService {
    private final AtomicLong counter = new AtomicLong();
    @Inject
    private RentalRepository rentalRepository;
    @Inject
    private BookRepository bookRepository;
    @Inject
    private UserRepository userRepository;

    public void addRental( String INSZ,String ISBN) throws ValidationException {
        Book rentedBook=null;
        User rentingUser=null;
        for (Book books : bookRepository.getAllBooks()) {
            if (ISBN.isEmpty()) {throw new ValidationException("ISBN is empty");}
            if(books.getISBN().equals(ISBN)){  rentedBook = books;}}
        for (User users : userRepository.getAllUsers()) {
            if (INSZ.isEmpty()) {throw new ValidationException("Insz is empty");}
            if (users.getInsz().equals(INSZ)) {rentingUser = users;}
        }
        for (Rental rentedBooks : rentalRepository.getAllRentals()) {
            if (rentedBook.getISBN().equals(ISBN)) {
                throw new ValidationException("The book is already rented");
            }}
        rentalRepository.addRental(new Rental(counter.incrementAndGet(), rentingUser, rentedBook, LocalDate.now().plusWeeks(3)));

    }

    public List<Rental> getAllRentals() {
        return rentalRepository.getAllRentals();
    }

    public void returnBook(String ISBN) throws ValidationException {
        boolean isFound = false;
        for (Rental rentedBooks : rentalRepository.getAllRentals()) {
            if (rentedBooks.getISBN().equals(ISBN)){
                isFound=true;
                if (rentedBooks.getDueDate().isBefore(LocalDate.now())){
                    System.out.println("Return date expired! You did not returned your book on time!");
                }
                rentalRepository.removeRental(rentedBooks);
            }
        }
        if (!isFound){ throw new ValidationException("This book was not rented"); }
    }

    public List<Rental> overdueSearch(){
         List<Rental> overdueBooks = new ArrayList<>();
        for (Rental rentedBooks : rentalRepository.getAllRentals()) {
            if (rentedBooks.getDueDate().isBefore(LocalDate.now())){overdueBooks.add(rentedBooks);}
        }
    return overdueBooks;}
}
