package contact;
import java.util.regex.Pattern;

public class Contact {
	private static final Pattern PHONE_PATTERN =
			Pattern.compile("^\\d{10}$");

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName,
                   String phone, String address) {

        validateContactId(contactId);

        this.contactId = contactId;
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private void validateContactId(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        if (contactId.length() > 10) {
            throw new IllegalArgumentException(
                    "Contact ID cannot be longer than 10 characters.");
        }
    }

    private void validateName(String name, String fieldName) {
        if (name == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null.");
        }

        if (name.length() > 10) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be longer than 10 characters.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null) {
            throw new IllegalArgumentException(
                    "Phone number cannot be null.");
        }

        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new IllegalArgumentException(
                    "Phone number must contain exactly 10 digits.");
        }
    }

    private void validateAddress(String address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }

        if (address.length() > 30) {
            throw new IllegalArgumentException(
                    "Address cannot be longer than 30 characters.");
        }
    }
}