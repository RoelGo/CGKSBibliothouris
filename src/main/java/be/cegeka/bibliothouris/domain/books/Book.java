package be.cegeka.bibliothouris.domain.books;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by davids on 25/01/2017.
 */
public class Book {

    private final String title;
    private final long ISBN;

    public Book(String title, long ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public long getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (ISBN != book.ISBN) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (int) (ISBN ^ (ISBN >>> 32));
        return result;
    }
}
