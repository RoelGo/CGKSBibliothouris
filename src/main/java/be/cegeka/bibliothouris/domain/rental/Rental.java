package be.cegeka.bibliothouris.domain.rental;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.users.User;

import java.time.LocalDate;

/**
 * Created by roelg on 25/01/2017.
 */
public class Rental {

    private final int id;
    private final User user;
    private final Book book;
    private final LocalDate rentalDate;

    public Rental(int id, User user, Book book, LocalDate rentalDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.rentalDate = rentalDate;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rental rental = (Rental) o;

        if (id != rental.id) return false;
        if (user != null ? !user.equals(rental.user) : rental.user != null) return false;
        if (book != null ? !book.equals(rental.book) : rental.book != null) return false;
        return rentalDate != null ? rentalDate.equals(rental.rentalDate) : rental.rentalDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (rentalDate != null ? rentalDate.hashCode() : 0);
        return result;
    }
}

