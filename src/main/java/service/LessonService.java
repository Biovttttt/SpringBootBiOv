package service;

import entity.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Lesson lesson);
    List<Lesson> getAllLessons();
    Lesson getLessonByID(Long id);
    void deleteLesson(Long id);
    void updateLesson(Long id, Lesson newLesson);
}
