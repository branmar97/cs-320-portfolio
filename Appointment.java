import java.util.Date;

public class Appointment {
    public static final int MAX_APPOINTMENT_ID_LENGTH = 10;
    public static final int MAX_DESCRIPTION_LENGTH = 50;

    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        validateFieldLength(appointmentId, MAX_APPOINTMENT_ID_LENGTH, "Appointment ID");
        validateFutureDate(appointmentDate);
        validateFieldLength(description, MAX_DESCRIPTION_LENGTH, "Description");

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setAppointmentDate(Date newAppointmentDate) {
        validateFutureDate(newAppointmentDate);
        this.appointmentDate = newAppointmentDate;
    }

    public void setDescription(String newDescription) {
        validateFieldLength(newDescription, MAX_DESCRIPTION_LENGTH, "Description");
        this.description = newDescription;
    }

    public static void validateFieldLength(String value, int maxLength, String fieldName) {
        if (value == null || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " must not be null and cannot be longer than " + maxLength + " characters.");
        }
    }

    public static void validateFutureDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date must not null and cannot be in the past.");
        }
    }
}
