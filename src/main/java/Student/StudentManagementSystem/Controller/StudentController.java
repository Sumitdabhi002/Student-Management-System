package Student.StudentManagementSystem.Controller;
import Student.StudentManagementSystem.Model.Student;
import Student.StudentManagementSystem.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentServices service;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return  service.getAllStudent();
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(service.getStudentById(id));
    }
    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student stud){
        return ResponseEntity.ok(service.addStudent(stud));
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student stud) {
        try {
            return ResponseEntity.ok(service.updateStudent(stud, id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        try {
            service.deleteStudent(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
