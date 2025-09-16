package Student.StudentManagementSystem.Services;

import Student.StudentManagementSystem.Model.Student;
import Student.StudentManagementSystem.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    StudentRepo repo;

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repo.findById(id);
    }

    public Student addStudent(Student stud) {
        return repo.save(stud);
    }

    public Student updateStudent(Student stud, int id) {
        Student student = repo.findById(id).map(existing -> {
                    existing.setName(stud.getName());
                    existing.setEmail(stud.getEmail());
                    existing.setCource(stud.getCource());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        return student;
    }


    public void deleteStudent(int id) {
         repo.deleteById(id);
    }
}
