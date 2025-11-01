package  com.mediTrack.module;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name is required")
    private String patientName;

    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    @NotBlank(message = "Status of appointment is required")
    private String appointmentStatus;
}