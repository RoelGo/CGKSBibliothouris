package be.cegeka.bibliothouris.domain.users;

public class User {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final long insz;
    private final String city;
    private final String street;
    private final int doorNumber;
    private final int postalCode;


    public User(long id, String firstName, String lastName, long insz, String city, String street, int doorNumber, int postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.insz = insz;
        this.city = city;
        this.street = street;
        this.doorNumber = doorNumber;
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getInsz() {
        return insz;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (insz != user.insz) return false;
        if (doorNumber != user.doorNumber) return false;
        if (postalCode != user.postalCode) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        return street != null ? street.equals(user.street) : user.street == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (insz ^ (insz >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + doorNumber;
        result = 31 * result + postalCode;
        return result;
    }
}
