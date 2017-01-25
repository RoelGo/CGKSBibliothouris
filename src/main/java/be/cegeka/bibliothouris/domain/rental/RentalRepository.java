package be.cegeka.bibliothouris.domain.rental;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roelg on 25/01/2017.
 */
@Named
public class RentalRepository {

    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

}


