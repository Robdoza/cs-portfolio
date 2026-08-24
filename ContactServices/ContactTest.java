package contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContactTest {

    @Test
    void testCreateContactSuccessfully() {
        Contact contact = new Contact(
                "a".repeat(10),
                "b".repeat(10),
                "c".repeat(10),
                "5125551234",
                "d".repeat(30));

        assertEquals("a".repeat(10), contact.getContactId());
        assertEquals("b".repeat(10), contact.getFirstName());
        assertEquals("c".repeat(10), contact.getLastName());
        assertEquals("5125551234", contact.getPhone());
        assertEquals("d".repeat(30), contact.getAddress());
    }

    @Test
    void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        null,
                        "Robert",
                        "Cardoza",
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testContactIdCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "a".repeat(11),
                        "Robert",
                        "Cardoza",
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        null,
                        "Cardoza",
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testFirstNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "a".repeat(11),
                        "Cardoza",
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        null,
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testLastNameCannotExceedTenCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        "a".repeat(11),
                        "5125551234",
                        "123 Main Street"));
    }

    @Test
    void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        "Cardoza",
                        null,
                        "123 Main Street"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "12345678901",
            "512ABC1234"
    })
    void testInvalidPhoneNumbers(String phone) {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        "Cardoza",
                        phone,
                        "123 Main Street"));
    }

    @Test
    void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        "Cardoza",
                        "5125551234",
                        null));
    }

    @Test
    void testAddressCannotExceedThirtyCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "1001",
                        "Robert",
                        "Cardoza",
                        "5125551234",
                        "a".repeat(31)));
    }

    @Test
    void testSetFirstNameSuccessfully() {
        Contact contact = createValidContact();

        contact.setFirstName("Alejandro");

        assertEquals("Alejandro", contact.getFirstName());
    }

    @Test
    void testSetFirstNameRejectsNullValue() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName(null));
    }

    @Test
    void testSetFirstNameRejectsValueOverTenCharacters() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName("a".repeat(11)));
    }

    @Test
    void testSetLastNameSuccessfully() {
        Contact contact = createValidContact();

        contact.setLastName("Rodriguez");

        assertEquals("Rodriguez", contact.getLastName());
    }

    @Test
    void testSetLastNameRejectsNullValue() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName(null));
    }

    @Test
    void testSetLastNameRejectsValueOverTenCharacters() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName("a".repeat(11)));
    }

    @Test
    void testSetPhoneSuccessfully() {
        Contact contact = createValidContact();

        contact.setPhone("7375559876");

        assertEquals("7375559876", contact.getPhone());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "12345678901",
            "512ABC1234"
    })
    void testSetPhoneRejectsInvalidValues(String phone) {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone(phone));
    }

    @Test
    void testSetPhoneRejectsNullValue() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone(null));
    }

    @Test
    void testSetAddressSuccessfully() {
        Contact contact = createValidContact();

        contact.setAddress("456 Oak Avenue");

        assertEquals("456 Oak Avenue", contact.getAddress());
    }

    @Test
    void testSetAddressRejectsNullValue() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress(null));
    }

    @Test
    void testSetAddressRejectsValueOverThirtyCharacters() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("a".repeat(31)));
    }

    private Contact createValidContact() {
        return new Contact(
                "1001",
                "Robert",
                "Cardoza",
                "5125551234",
                "123 Main Street");
    }
}