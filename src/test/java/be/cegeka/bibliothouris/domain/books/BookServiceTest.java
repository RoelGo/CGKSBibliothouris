package be.cegeka.bibliothouris.domain.books;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
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
    @Mock
    private BookValidator bookValidator;

    /*
    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(bookRepository, name, ISBN);
    }
  */
    @Test
    public void addBook() throws Exception {
        when(bookValidator.isValid("978902")).thenReturn(true);
        bookService.addBook("Harry Potter", "978902", "J.K", "Rowling");
        verify(bookRepository).addBook(new Book("Harry Potter", "978902", "J.K", "Rowling"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("Harry 1", "123567890", "J.K", "Rowling");
        Book book2 = new Book("Harry 2", "1235670123", "J.K", "Rowling");
        Book book3 = new Book("Harry 3", "356701231", "J.K", "Rowling");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);

    }





}