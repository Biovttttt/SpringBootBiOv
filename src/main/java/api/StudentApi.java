package api;

import entity.Company;
import entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.StudentService;

@Controller
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentApi {
    private final StudentService studentService;


    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students", studentService.getStudents());
   return "students";
    }

    @GetMapping("/new")
    public String createStudent(Model model){
        model.addAttribute("newStudent", new Student());
     return "createStudent";
    }
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("newStudent")Student student){
     studentService.saveStudent(student);
     return "redirect:/api/students";
    }
    @GetMapping("/{id}/get")
    public String getStudent(@PathVariable Long id, Model model){
        model.addAttribute("updateStudent",studentService.getStudentById(id));
       return "updateStudent";
    }
    @PostMapping("/{id}/update")
    public String updateStudent(@PathVariable Long id, @ModelAttribute ("updateStudent ")Student student){
     studentService.updateStudent(id, student);
     return "redirect:/api/students";
    }
    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/api/students";
    }
}
