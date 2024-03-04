import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentServiceTest {
    @Test
    public void testCreateAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.createAppointment(new Appointment("1", new Date(), "Description"));
        Map<String, Appointment> appointments = appointmentService.getAppointments();

        assertTrue(appointments.containsKey("1"));
    }

    @Test
    public void testCreateAppointmentDuplicateIds() {
        AppointmentService appointmentService = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.createAppointment(new Appointment("1", new Date(), "Description 1"));
            appointmentService.createAppointment(new Appointment("1", new Date(), "Description 2"));
        });
    }

    @Test
    public void testCancelAppointment() {
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.createAppointment(new Appointment("1", new Date(), "Will cancel"));
        appointmentService.cancelAppointment("1");
        Map<String, Appointment> appointments = appointmentService.getAppointments();

        assertFalse(appointments.containsKey("1"));
    }

    @Test
    public void testCancelAppointmentIdNotFound() {
        AppointmentService appointmentService = new AppointmentService();
        assertThrows(NoSuchElementException.class, () -> appointmentService.cancelAppointment("20"));
    }
}
