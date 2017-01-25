package be.cegeka.bibliothouris.domain.books;

import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserRepository;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by davids on 25/01/2017.
 */
public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    /*
    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(bookRepository, name, ISBN);
    }
  */
    @Test
    public void addBook() throws Exception {
        bookService.addBook("Harry Potter", 123456789, "J.K", "Rowling");
        verify(bookRepository).addBook(new Book("Harry Potter", 123456789, "J.K", "Rowling"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("Harry 1", 123567890, "J.K", "Rowling");
        Book book2 = new Book("Harry 2", 1235670123, "J.K", "Rowling");
        Book book3 = new Book("Harry 3", 356701231, "J.K", "Rowling");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);

    }

}