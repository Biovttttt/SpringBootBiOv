package service.serviceImpl;

import entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.StudentRepository;
import service.StudentService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public void saveStudent(Student student) {
studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
    }

    @Override
    public void deleteStudentById(Long id) {
if (studentRepository.existsById(id)) {
    studentRepository.deleteById(id);
}else {
    throw new RuntimeException("Student not found");
}
    }

    @Override
    public void updateStudent(Long id, Student newStudent) {
Student student=getStudentById(id);
student.setFirstName(newStudent.getFirstName());
student.setLastName(newStudent.getLastName());
student.setPhoneNumber(newStudent.getPhoneNumber());
student.setEmail(newStudent.getEmail());
studentRepository.save(student);
    }
}
