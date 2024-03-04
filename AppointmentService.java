import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public Map<String, Appointment> getAppointments() {
        return appointments;
    };

    public void createAppointment(Appointment newAppointment) {
        String appointmentId = newAppointment.getAppointmentId();
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " already exists.");
        }

        appointments.put(appointmentId, newAppointment);
    }

    public void cancelAppointment(String appointmentId) {
        if (appointments.containsKey(appointmentId)) {
            appointments.remove(appointmentId);
        } else {
            throw new NoSuchElementException("Appointment with ID " + appointmentId + " was not found.");
        }
    }
}
