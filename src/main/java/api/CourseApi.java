package api;

import entity.Company;
import entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.CourseRepository;
import service.CourseService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseApi {
    private final CourseService courseService;

    @GetMapping
    public String getAllCourses(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        return "getAllCourses";
    }
    @GetMapping("/new")
    public String createCourse(Model model){
        model.addAttribute("newCourse", new Course());
        return "createCourse";
    }
    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("newCourse")Course course){
        courseService.saveCompany(course);
        return "redirect:/api/courses";
    }
    @GetMapping("/{id}/get")
    public String getCourse(@PathVariable Long id, Model model){
        model.addAttribute("updateCourse",courseService.getCourseById(id));
        return "updateCourse";
    }
    @PostMapping("/{id}/update")
    public String updateCourse(@PathVariable Long id, @ModelAttribute ("updateCourse ")Course course){
      courseService.updateCourse(id, course);
        return "redirect:/api/courses";
    }
    @GetMapping("/{id}/delete")
    public String deleteCourse(@PathVariable Long id){
     courseService.deleteCourse(id);
        return "redirect:/api/courses";
    }
}
