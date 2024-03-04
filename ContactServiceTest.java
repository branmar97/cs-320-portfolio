import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    // Using assertions to verify that the expected results match
    // the actual results after performing operations on the ContactService.

    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contactService.addContact(contact);

        assertEquals(1, contactService.getContacts().size());
        assertTrue(contactService.getContacts().containsKey("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("1234567890");

        assertEquals(0, contactService.getContacts().size());
        assertFalse(contactService.getContacts().containsKey("1234567890"));
    }

    @Test
    public void testUpdateFirstNameContactField() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactField("1234567890", "firstName", "Jane");

        assertEquals("Jane", contactService.getContacts().get("1234567890").firstName());
    }

    @Test
    public void testUpdateLastNameContactField() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactField("1234567890", "lastName", "Kennedy");

        assertEquals("Kennedy", contactService.getContacts().get("1234567890").lastName());
    }

    @Test
    public void testUpdatePhoneContactField() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactField("1234567890", "phone", "0987654321");

        assertEquals("0987654321", contactService.getContacts().get("1234567890").phone());
    }

    @Test
    public void testUpdateAddressContactField() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.updateContactField("1234567890", "address", "321 Main St");

        assertEquals("321 Main St", contactService.getContacts().get("1234567890").address());
    }
}
