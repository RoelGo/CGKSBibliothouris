package be.cegeka.bibliothouris.domain.rental;

import be.cegeka.bibliothouris.domain.books.Book;
import be.cegeka.bibliothouris.domain.users.User;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by rodrPMFF on 26/01/2017.
 */
public class rentalServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private RentalRepository rentalservice;

    @Mock
    private RentalRepository rentalRepository;

    @Test
    public void addRental() throws Exception {
    Book book1 = new Book("Harry 1", "123567890", "J.K", "Rowling");
    User user1 = new User(11, "Seppe","Gielen","36546464654","Leuven","'t torentje","10","2500");
    Rental testRental = new Rental(11,user1, book1,LocalDate.now());
    rentalRepository.addRental(testRental);
        verify(rentalRepository).addRental(new Rental(11,user1,book1,LocalDate.now()));
    }

    public void testList() throws Exception{
        Book book1 = new Book("Harry 1", "123567890", "J.K", "Rowling");
        Book book2 = new Book("Harry 2", "123567891", "J.K", "Rowling");
        Book book3 = new Book("Harry 3", "123567890", "J.K", "Rowling");
        User user1 = new User(11, "Seppe","Gielen","36546464654","Leuven","'t torentje","10","2500");
        User user2 = new User(12, "Sanne","Vermeiren","36546464656","Leuven","'t torentje","10","2500");
        User user3 = new User(13, "Wouter","Stoel","36546464654","Leuven","'t torentje","10","2500");

        Rental testRental1 = new Rental(11,user1, book1, LocalDate.now() );
        Rental testRental2 = new Rental(12,user2, book2, LocalDate.now() );
        Rental testRental3 = new Rental(13,user3, book3, LocalDate.now() );

      rentalRepository.addRental(testRental1);
      rentalRepository.addRental(testRental2);
      rentalRepository.addRental(testRental3);

        when(rentalRepository.getAllRentals()).thenReturn(Arrays.asList(testRental1, testRental2, testRental3));

        assertThat(rentalservice.getAllRentals()).containsOnly(testRental1, testRental2, testRental3);

    }


}

