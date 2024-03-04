public class Contact {
    public static final int MAX_CONTACT_ID_LENGTH = 10;
    public static final int MAX_FIRST_NAME_LENGTH = 10;
    public static final int MAX_LAST_NAME_LENGTH = 10;
    public static final int PHONE_LENGTH = 10;
    public static final int MAX_ADDRESS_LENGTH = 30;

    private final String contactId;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateField(contactId, MAX_CONTACT_ID_LENGTH, "contactId");
        validateField(firstName, MAX_FIRST_NAME_LENGTH, "firstName");
        validateField(lastName, MAX_LAST_NAME_LENGTH, "lastName");
        validateField(phone, PHONE_LENGTH, "phone");
        validateField(address, MAX_ADDRESS_LENGTH, "address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public static void validateField(String value, int length, String fieldName) {
        if (fieldName.equals("phone") && (value == null || value.length() != length)) {
            throw new IllegalArgumentException(fieldName + " must be " + length + " digits.");
        }

        if (value == null || value.length() > length) {
            throw new IllegalArgumentException(fieldName + " must not be null and cannot be longer than " + length + " characters.");
        }
    }

    // Getter methods to retrieve the values of the fields
 
    public String contactId() {
        return contactId;
    }


    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String phone() {
        return phone;
    }

    public String address() {
        return address;
    }
}

