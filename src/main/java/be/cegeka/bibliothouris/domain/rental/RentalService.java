package be.cegeka.bibliothouris.domain.rental;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.users.User;

import javax.inject.Inject;
import javax.inject.Named;
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

    public void addRental(Book book, User user) {
        rentalRepository.addRental(new Rental(counter.incrementAndGet(), user, book, LocalDate.now()));
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.getAllRentals();
    }

}
