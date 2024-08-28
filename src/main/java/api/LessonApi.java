package api;

import entity.Instructor;
import entity.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.LessonService;

@Controller
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonApi {
    private final LessonService lessonService;

    @GetMapping
    public String getAllLessons(Model model) {
        model.addAttribute("lessons", lessonService.getAllLessons());
        return "getAllLessons";
    }
    @GetMapping("/new")
    public String createLesson(Model model) {
        model.addAttribute("newLesson", new Lesson());
        return "createnewLesson";
    }
    @PostMapping("/save")
    public String saveLesson(@ModelAttribute("newLesson") Lesson lesson) {
       lessonService.saveLesson(lesson);
      return "redirect:/api/lessons";
    }
    @GetMapping("/{id}/get")
    public String getLessonById(Model model, @PathVariable Long id) {
        model.addAttribute("updateLesson", lessonService.getLessonByID(id));
    return "updateLesson";
    }
    @GetMapping("/{id}/update")
    public String updateLessonById( @PathVariable Long id,@ModelAttribute("updateLesson")Lesson lesson) {
        lessonService.updateLesson(id, lesson);
    return "redirect:/api/lessons";
    }
    @GetMapping("/{id}/delete")
    public String deleteLessonById(@PathVariable Long id) {
        lessonService.deleteLesson(id);
        return "redirect:/api/lessons";
    }
}
