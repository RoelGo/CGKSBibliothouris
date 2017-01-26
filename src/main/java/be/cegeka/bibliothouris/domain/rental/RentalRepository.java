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
        String errorMessage = "";
        if (rental.getBook().getISBN().isEmpty()) {
            errorMessage += "ISBN is empty";
        }
        if (rental.getUser().getInsz().isEmpty()){
            errorMessage += "Insz is empty";
        }
        if (errorMessage.isEmpty()){
        rentals.add(rental);}
        else {
            throw new ValidationException(errorMessage);
        }
    }

    public void removeRental(Rental rental) {
        rentals.remove(rental);
    }

    public List<Rental> getAllRentals() {
        return rentals;
    }

}


