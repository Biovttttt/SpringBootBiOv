package peaksoft.springbootlms.service;

import peaksoft.springbootlms.entity.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student student);
    List<Student> getStudents();
    Student getStudentById(Long id);
    void deleteStudentById(Long id);
    void updateStudent(Long id, Student newStudent);
}
