package api;

import entity.Instructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.InstructorService;

@Controller
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorApi {
    private final InstructorService instructorService;

  @GetMapping
    public String getAllInstructors(Model model) {
        model.addAttribute("instructors", instructorService.getAllInstructors());
        return "getALlInstructors";
    }
    @GetMapping("/new")
    private String createInstructor(Model model) {
      model.addAttribute("newInstructor", new Instructor());
      return "createInstructor";
    }
    @PostMapping("/save")
    public String saveInstructor(@ModelAttribute ("newInstructor") Instructor instructor) {
      instructorService.saveInstructor(instructor);
      return "redirect:/instructors";
    }
    @GetMapping("/{id}/get")
    public String getInstructorById(Model model, @PathVariable Long id) {
      model.addAttribute("updateInstructor", instructorService.getInstructorById(id));
      return "updateInstructor";
    }
    @GetMapping("/{id}/update")
    public String updateInstructorById( @PathVariable Long id,@ModelAttribute("updateInstructor")Instructor instructor) {
      instructorService.updateInstructor(id, instructor);
      return "redirect:/instructors";
    }
    @GetMapping("/{id}/delete")
    public String deleteInstructorById(@PathVariable Long id) {
      instructorService.deleteInstructorById(id);
      return "redirect:/instructors";
    }
}
