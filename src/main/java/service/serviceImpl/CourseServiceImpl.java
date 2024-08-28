package service.serviceImpl;

import entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseRepository;
import service.CourseService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public void saveCompany(Course course) {
courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
"Course with id"+id+"not found!"));
    }

    @Override
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Company with id "+id+" not found!");
        }
    }

    @Override
    public void updateCourse(Long id, Course newCourse) {
Course course=getCourseById(id);
course.setCourseName(newCourse.getCourseName());
course.setDateOfStart(newCourse.getDateOfStart());
course.setDescription(newCourse.getDescription());
courseRepository.save(course);
    }
}
