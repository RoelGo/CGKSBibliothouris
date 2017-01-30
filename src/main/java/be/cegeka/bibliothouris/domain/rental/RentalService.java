package be.cegeka.bibliothouris.domain.rental;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.users.User;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.time.LocalDate;
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

    public void addRental(Book book, User user, LocalDate dueDate) throws ValidationException {
        rentalRepository.addRental(new Rental(counter.incrementAndGet(), user, book, LocalDate.now().plusWeeks(3)));

    }

    public List<Rental> getAllRentals() {
        return rentalRepository.getAllRentals();
    }

    public void returnBook(Rental rental) throws ValidationException {
        boolean isUnique = true;
        for (Rental rentedBooks : rentalRepository.getAllRentals()) {
           isUnique = !rentedBooks.getBook().getISBN().equals(rental.getBook().getISBN());
        }
        if (!isUnique){
            rentalRepository.removeRental(rental);
            if (rental.getDueDate().isBefore(LocalDate.now())){
                System.out.println("Return date expired! You did not returned your book on time!");
            }
        }
        else {throw new ValidationException("This book was not rented");}
    }
}
