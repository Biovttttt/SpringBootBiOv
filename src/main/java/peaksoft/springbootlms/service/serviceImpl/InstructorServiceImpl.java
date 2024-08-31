package peaksoft.springbootlms.service.serviceImpl;

import peaksoft.springbootlms.entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springbootlms.repository.InstructorRepository;
import peaksoft.springbootlms.service.InstructorService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public void saveInstructor(Instructor instructor) {
instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                      "Instructor with id"+id+"not found!"
                )
        );
    }

    @Override
    public void deleteInstructorById(Long id) {
if (!instructorRepository.existsById(id)){
    instructorRepository.deleteById(id);
}else {
    throw new NoSuchElementException(
            "Instructor with id"+id+"not found!");
}
    }

    @Override
    public void updateInstructor(Long id, Instructor newInstructor) {
Instructor instructor=getInstructorById(id);
instructor.setFirstname(newInstructor.getFirstname());
instructor.setLastname(newInstructor.getLastname());
instructor.setPhoneNumber(newInstructor.getPhoneNumber());
instructor.setSpecialization(newInstructor.getSpecialization());
instructorRepository.save(instructor);
    }
}
