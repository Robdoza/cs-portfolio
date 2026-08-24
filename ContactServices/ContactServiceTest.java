package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();

        contact = new Contact(
                "1001",
                "Robert",
                "Cardoza",
                "5125551234",
                "123 Main Street");
    }

    @Test
    void testAddContactSuccessfully() {
        contactService.addContact(contact);

        assertSame(contact, contactService.getContact("1001"));
        assertEquals(1, contactService.getContactCount());
    }

    @Test
    void testAddContactRejectsDuplicateId() {
        Contact duplicateContact = new Contact(
                "1001",
                "Alex",
                "Garcia",
                "7375559876",
                "456 Oak Avenue");

        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(duplicateContact));

        assertEquals(1, contactService.getContactCount());
    }

    @Test
    void testAddContactRejectsNullContact() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.addContact(null));
    }

    @Test
    void testDeleteContactSuccessfully() {
        contactService.addContact(contact);

        contactService.deleteContact("1001");

        assertNull(contactService.getContact("1001"));
        assertEquals(0, contactService.getContactCount());
    }

    @Test
    void testDeleteContactRejectsUnknownId() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.deleteContact("9999"));
    }

    @Test
    void testUpdateFirstNameSuccessfully() {
        contactService.addContact(contact);

        contactService.updateContactFirstName("1001", "Alejandro");

        assertEquals(
                "Alejandro",
                contactService.getContact("1001").getFirstName());
    }

    @Test
    void testUpdateLastNameSuccessfully() {
        contactService.addContact(contact);

        contactService.updateContactLastName("1001", "Rodriguez");

        assertEquals(
                "Rodriguez",
                contactService.getContact("1001").getLastName());
    }

    @Test
    void testUpdatePhoneSuccessfully() {
        contactService.addContact(contact);

        contactService.updateContactPhone("1001", "7375559876");

        assertEquals(
                "7375559876",
                contactService.getContact("1001").getPhone());
    }

    @Test
    void testUpdateAddressSuccessfully() {
        contactService.addContact(contact);

        contactService.updateContactAddress(
                "1001",
                "456 Oak Avenue");

        assertEquals(
                "456 Oak Avenue",
                contactService.getContact("1001").getAddress());
    }

    @Test
    void testUpdateRejectsUnknownContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContactFirstName(
                        "9999",
                        "Alejandro"));
    }

    @Test
    void testUpdateRejectsInvalidFieldValue() {
        contactService.addContact(contact);

        assertThrows(IllegalArgumentException.class, () ->
                contactService.updateContactPhone(
                        "1001",
                        "12345"));
    }
}