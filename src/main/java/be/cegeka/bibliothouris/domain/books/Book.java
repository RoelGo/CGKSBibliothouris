package be.cegeka.bibliothouris.domain.books;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * Created by davids on 25/01/2017.
 */
public class Book {

    private final String title;
    private final long ISBN;
    private final String authorFirstName;
    private final String authorLastName;

    public Book(String title, long ISBN, String authorFirstName, String authorLastName) {
        this.title = title;
        this.ISBN = ISBN;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
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
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authorFirstName != null ? !authorFirstName.equals(book.authorFirstName) : book.authorFirstName != null)
            return false;
        return authorLastName != null ? authorLastName.equals(book.authorLastName) : book.authorLastName == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (int) (ISBN ^ (ISBN >>> 32));
        result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        return result;
    }
}
