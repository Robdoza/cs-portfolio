package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        Contact existingContact =
                contacts.putIfAbsent(contact.getContactId(), contact);

        if (existingContact != null) {
            throw new IllegalArgumentException(
                    "A contact with this ID already exists.");
        }
    }

    public void deleteContact(String contactId) {
        validateExistingContactId(contactId);
        contacts.remove(contactId);
    }

    public void updateContactFirstName(String contactId, String firstName) {
        Contact contact = getRequiredContact(contactId);
        contact.setFirstName(firstName);
    }

    public void updateContactLastName(String contactId, String lastName) {
        Contact contact = getRequiredContact(contactId);
        contact.setLastName(lastName);
    }

    public void updateContactPhone(String contactId, String phone) {
        Contact contact = getRequiredContact(contactId);
        contact.setPhone(phone);
    }

    public void updateContactAddress(String contactId, String address) {
        Contact contact = getRequiredContact(contactId);
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    public int getContactCount() {
        return contacts.size();
    }

    private Contact getRequiredContact(String contactId) {
        validateExistingContactId(contactId);
        return contacts.get(contactId);
    }

    private void validateExistingContactId(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(
                    "No contact exists with the provided ID.");
        }
    }
}