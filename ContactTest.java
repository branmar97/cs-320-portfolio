import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("1234567890", contact.contactId());
        assertEquals("John", contact.firstName());
        assertEquals("Doe", contact.lastName());
        assertEquals("1234567890", contact.phone());
        assertEquals("123 Main St", contact.address());
    }

    @Test
    public void testContactCreationNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("11122233344455566", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "LongerThan10Chars", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "LongerThan10Chars", "1234567890", "123 Main St"));
    }

    @Test
    public void testContactCreationPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "123456789", "123 Main St"));
    }

    @Test
    public void testContactCreationPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    public void testContactCreationNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", null, "123 Main St"));
    }

    @Test
    public void testContactCreationNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "1234567890", null));
    }

    @Test
    public void testContactCreationInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "1234567890", "Super long invalid address that is longer than 30 characters"));
    }
}
