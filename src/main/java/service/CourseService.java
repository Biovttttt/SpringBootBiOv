package service;

import entity.Course;

import java.util.List;

public interface CourseService {
    void saveCompany ( Course course );
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void deleteCourse(Long id);
    void updateCourse(Long id,Course newCourse);
}
