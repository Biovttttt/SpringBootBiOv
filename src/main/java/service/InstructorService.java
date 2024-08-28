package service;

import entity.Instructor;

import java.util.List;

public interface InstructorService {
    void saveInstructor(Instructor instructor);
    List<Instructor> getAllInstructors();
    Instructor getInstructorById(Long id);
    void deleteInstructorById(Long id);
    void updateInstructor(Long id,Instructor newInstructor);
}
