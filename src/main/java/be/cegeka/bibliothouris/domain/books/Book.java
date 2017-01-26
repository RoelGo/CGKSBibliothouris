package be.cegeka.bibliothouris.domain.books;

/**
 * Created by davids on 25/01/2017.
 */
public class Book {

    private final String title;
    private final String ISBN;
    private final String authorFirstName;
    private final String authorLastName;

    public Book(String title, String ISBN, String authorFirstName, String authorLastName) {
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

    public String getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null) return false;
        if (authorFirstName != null ? !authorFirstName.equals(book.authorFirstName) : book.authorFirstName != null)
            return false;
        return authorLastName != null ? authorLastName.equals(book.authorLastName) : book.authorLastName == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (ISBN != null ? ISBN.hashCode() : 0);
        result = 31 * result + (authorFirstName != null ? authorFirstName.hashCode() : 0);
        result = 31 * result + (authorLastName != null ? authorLastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ISBN=" + ISBN +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                '}';
    }
}
