package be.cegeka.bibliothouris.domain.rental;

import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roelg on 25/01/2017.
 */
@Named
public class RentalRepository {

    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) throws ValidationException {

        if (rental.getBook().getISBN().isEmpty()) {
            throw new ValidationException("ISBN is empty");
        }else if (rental.getUser().getInsz().isEmpty()){
            throw new ValidationException("Insz is empty");
        } else {
        rentals.add(rental);
        }
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

}


