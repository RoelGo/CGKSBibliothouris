package be.cegeka.bibliothouris.domain.users;

public class User {

    private final long id;
    private final String firstName;
    private final String lastName;
    private final String insz;
    private final String city;
    private final String street;
    private final String doorNumber;
    private final String postalCode;


    public User(long id, String firstName, String lastName, String insz, String city, String street, String doorNumber, String postalCode) {
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

    public String getInsz() {
        return insz;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (insz != null ? !insz.equals(user.insz) : user.insz != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (street != null ? !street.equals(user.street) : user.street != null) return false;
        if (doorNumber != null ? !doorNumber.equals(user.doorNumber) : user.doorNumber != null) return false;
        return postalCode != null ? postalCode.equals(user.postalCode) : user.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (insz != null ? insz.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (doorNumber != null ? doorNumber.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }
}
