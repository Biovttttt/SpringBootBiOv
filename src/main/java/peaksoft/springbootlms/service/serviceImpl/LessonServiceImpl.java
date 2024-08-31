package peaksoft.springbootlms.service.serviceImpl;

import peaksoft.springbootlms.entity.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springbootlms.repository.LessonRepository;
import peaksoft.springbootlms.service.LessonService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Override
    public void saveLesson(Lesson lesson) {
lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> getAllLessons() {

        return lessonRepository.findAll();
    }

    @Override
    public Lesson getLessonByID(Long id) {
        return lessonRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                        "Lesson with ID " + id + " not found"));
    }

    @Override
    public void deleteLesson(Long id) {
if (!lessonRepository.existsById(id)){
    lessonRepository.deleteById(id);
}else {
    throw new NoSuchElementException(
            "Lesson with ID " + id + " not found");
}
    }

    @Override
    public void updateLesson(Long id, Lesson newLesson) {
Lesson lesson = getLessonByID(id);
lesson.setLessonName(newLesson.getLessonName());
lessonRepository.save(lesson);
    }
}
