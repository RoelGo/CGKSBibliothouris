package be.cegeka.bibliothouris.domain.books;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /*
    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(bookRepository, name, ISBN);
    }
  */
    @Test
    public void addBook() throws Exception {
        bookService.addBook("Harry Potter", "123456789", "J.K", "Rowling");
        verify(bookRepository).addBook(new Book("Harry Potter", "123456789", "J.K", "Rowling"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("Harry 1", "123567890", "J.K", "Rowling");
        Book book2 = new Book("Harry 2", "1235670123", "J.K", "Rowling");
        Book book3 = new Book("Harry 3", "356701231", "J.K", "Rowling");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2);

    }

    @Test
    public void searchBook() throws Exception {
        List<Book> testList = new ArrayList<>();
        List<Book> testList2 = new ArrayList<>();
        Book testBook = new Book("Harry 2", "1235670123", "J.K", "Rowling");
        Book testBook2 = new Book("Matilda", "3335670123", "Roald", "Dahl");
        Book testBook3 = new Book("Harry 3", "333567884", "J.K", "Rowling");
        Book testBook4 = new Book("The Old Man And The Sea", "3335679456", "Ernest", "Hemingway");
        Book testBook5 = new Book("Trainspotting", "33356701332", "Irvin", "Welsh");
        testList.add(testBook);
        testList.add(testBook3);
        testList2.add(testBook3);
        testList2.add(testBook2);

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(testBook, testBook2, testBook3, testBook4, testBook5));

        assertThat(bookService.searchBook("J.K")).isEqualTo(testList);
        assertThat(bookService.searchBook("Irvin")).isEqualTo(Arrays.asList(testBook5));
        //assertThat(bookService.searchBook("333")).isEqualTo(testList2);
        assertThat(bookService.searchBook("Rowling")).isEqualTo(testList);
    }

}