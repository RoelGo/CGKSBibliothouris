package be.cegeka.bibliothouris.domain.rental;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roelg on 25/01/2017.
 */
public class RentalRepository {

    private List<Rental> rentals = new ArrayList<>();

    private void addRental(Rental rental){
        rentals.add(rental);
    }

}


