package Student.StudentManagementSystem.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message ="Name is required")
    private String name;
    @NotBlank(message ="Email is required")
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message ="Cource is required")
    private String cource;

}
