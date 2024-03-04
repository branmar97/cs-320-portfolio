import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppointmentTest {
    @Test
    public void testInstantiateAppointment() {
        Date appointmentDate = new Date();
        Appointment appointment = new Appointment("1", appointmentDate, "Description 1");

        assertEquals("1", appointment.getAppointmentId());
        assertEquals(appointmentDate.getTime(), appointment.getAppointmentDate().getTime());
        assertEquals("Description 1", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentId() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, new Date(), "Description 1"));
    }

    @Test
    public void testInvalidAppointmentDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", null, "Description 1"));
    }

    @Test
    public void testPastAppointmentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1); // Set the date to January 1, 2020
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", calendar.getTime(), "Description 1"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", new Date(), null));
    }

    @Test
    public void testLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("1", new Date(), "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"));
    }

    @Test
    public void testGetAppointmentId() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");
        assertEquals("1", appointment.getAppointmentId());
    }

    @Test
    public void testGetAppointmentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Add 1 day
        Date date = calendar.getTime();
        Appointment appointment = new Appointment("1", date, "Description 1");

        assertEquals(date.getTime(), appointment.getAppointmentDate().getTime());
    }

    @Test
    public void testGetAppointmentDescription() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");
        assertEquals("Description 1", appointment.getDescription());
    }

    @Test
    public void testSetAppointmentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1); // Add 1 day

        Appointment appointment = new Appointment("1", new Date(), "Description 1");
        Date newDate = calendar.getTime();
        appointment.setAppointmentDate(newDate);

        assertEquals(newDate.getTime(), appointment.getAppointmentDate().getTime());
    }

    @Test
    public void testSetAppointmentDatePastDate() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1); // Set the date to January 1, 2020

        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(calendar.getTime()));
    }

    @Test
    public void testSetAppointmentDateNull() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");

        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
    }

    @Test
    public void testSetAppointmentDescription() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");
        appointment.setDescription("Description 2");

        assertEquals("Description 2", appointment.getDescription());
    }

    @Test
    public void testSetAppointmentDescriptionTooLong() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");

        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription("This is way too long of a description and is probably going to throw an error because the limit is 50 chars and this is definitely more than that."));
    }

    @Test
    public void testSetAppointmentDescriptionNull() {
        Appointment appointment = new Appointment("1", new Date(), "Description 1");

        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }

    @Test
    public void testValidateFieldLengthTooLong() {
        assertThrows(IllegalArgumentException.class, () -> Appointment.validateFieldLength("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", Appointment.MAX_DESCRIPTION_LENGTH, "Description"));
    }

    @Test
    public void testValidateFieldLengthNull() {
        assertThrows(IllegalArgumentException.class, () -> Appointment.validateFieldLength(null, Appointment.MAX_DESCRIPTION_LENGTH, "Description"));
    }
}
