package models;

public class FormData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String email;
    private final String contactNumber;

    public FormData(String firstName, String middleName, String lastName, String email, String contactNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
