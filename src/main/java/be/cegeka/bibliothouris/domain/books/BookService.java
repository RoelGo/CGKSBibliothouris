package be.cegeka.bibliothouris.domain.books;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davids on 25/01/2017.
 */
@Named
public class BookService {

    @Inject
    private BookRepository bookRepository;
    @Inject
    private BookValidator bookValidator;


    public void addBook(String title, String ISBN, String firstName, String lastName) throws ValidationException {
        if (bookValidator.isValid(ISBN)) {
            bookRepository.addBook(new Book(title, ISBN, firstName, lastName));
        }
        else{
            throw new ValidationException("ISBN is not valid.");
        }

    }

    public String getBooksByCriteria(String criteria){
        String testCriteria = criteria.replaceAll("\\*",".+");
        if (testCriteria.length() > 1){
            if (testCriteria.substring(0,2).equals(".+")){
                testCriteria = ".+" + criteria.substring(2,testCriteria.length());
            }
            if (testCriteria.substring(testCriteria.length() - 2, testCriteria.length()).equals(".+")){
                testCriteria = criteria.substring(0,testCriteria.length()-2)+".*";
            }
        }
        return testCriteria;
    }

    public List<Book> searchStringByIsbn(String isbn) throws ValidationException {
        List<Book> foundBooks = new ArrayList<>();
        String testIsbn = getBooksByCriteria(isbn);
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getISBN().matches(testIsbn)) {
                foundBooks.add(book);
            }
            if (foundBooks.isEmpty()) {
                throw new ValidationException("No matching ISBN was found.");
            }
        }
        return foundBooks;
    }

    public List<Book> searchStringByAuthor(String Author) throws ValidationException {
        List<Book> foundBooks = new ArrayList<>();
        String testAuthor = getBooksByCriteria(Author);
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getAuthorFirstName().matches(testAuthor) || book.getAuthorLastName().matches(testAuthor) ) {
                foundBooks.add(book);
            }
            if (foundBooks.isEmpty()) {
                throw new ValidationException("No matching Author was found.");
            }
        }
        return foundBooks;
    }

    public List<Book> searchStringByTitle(String Title) throws ValidationException {
        List<Book> foundBooks = new ArrayList<>();
        String testTitle = getBooksByCriteria(Title);
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().matches(testTitle)) {
                foundBooks.add(book);
            }
            if (foundBooks.isEmpty()) {
                throw new ValidationException("No matching Title was found.");
            }
        }
        return foundBooks;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }




   /* public List<Book> searchBook(String searchInput) {
        List<Book> searchList = bookRepository.getAllBooks();
        List<Book> hitList = new ArrayList<>();
        for (Book book : searchList) {
            if (hasMatch(book, searchInput)) {
                hitList.add(book);
            }
        }
        if (hitList.size() < 1) {
            System.out.println("No matches found");
        }
        return hitList;
    }

    protected boolean hasMatch(Book book, String searchInput) {

        return (book.getISBN().matches("(.*)" + searchInput + "(.*)") ||
                book.getAuthorFirstName().matches("(.*)" + searchInput + "(.*)") ||
               book.getAuthorLastName().matches("(.*)" + searchInput + "(.*)"));
    }*/

}