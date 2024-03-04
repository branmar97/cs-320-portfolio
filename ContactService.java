import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts;

    // Constructor to initialize an empty ContactService
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Method to add a contact to the service
    public void addContact(Contact contact) {
        contacts.put(contact.contactId(), contact);
    }

    // Method to delete a contact by contact ID
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    // Method to update a specific field of a contact by contact ID
    public void updateContactField(String contactId, String fieldName, String newValue) {
        Contact contact = contacts.get(contactId);

        if (contact != null) {
            switch (fieldName) {
                case "firstName":
                    Contact.validateField(newValue, Contact.MAX_FIRST_NAME_LENGTH, fieldName);
                    contact = new Contact(contact.contactId(), newValue, contact.lastName(), contact.phone(), contact.address());
                    break;
                case "lastName":
                    Contact.validateField(newValue, Contact.MAX_LAST_NAME_LENGTH, fieldName);
                    contact = new Contact(contact.contactId(), contact.firstName(), newValue, contact.phone(), contact.address());
                    break;
                case "phone":
                    Contact.validateField(newValue, Contact.PHONE_LENGTH, fieldName);
                    contact = new Contact(contact.contactId(), contact.firstName(), contact.lastName(), newValue, contact.address());
                    break;
                case "address":
                    Contact.validateField(newValue, Contact.MAX_ADDRESS_LENGTH, fieldName);
                    contact = new Contact(contact.contactId(), contact.firstName(), contact.lastName(), contact.phone(), newValue);
                    break;
                default:
                    // Handle unknown field
                    break;
            }

            contacts.put(contactId, contact);
        }
    }

    // Getter methods

    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
