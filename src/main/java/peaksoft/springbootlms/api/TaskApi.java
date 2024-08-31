package peaksoft.springbootlms.api;

import peaksoft.springbootlms.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.springbootlms.service.TaskService;

@Controller
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskApi {
    private final TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "getAlltasks";
    }
    @GetMapping("/new")
    public String createNewTask(Model model) {
        model.addAttribute("newTask", new Task());
        return "createNewTask";
    }
    @PostMapping("/save")
    public String saveTask(@ModelAttribute("newTask") Task task) {
        taskService.saveTask(task);
        return "redirect:/api/tasks";
    }
    @GetMapping("{id}/get")
    public String getTaskById(@PathVariable Long id, Model model) {
        model.addAttribute("updateTask", taskService.getTaskById(id));
        return "updateTask";
    }
  @PostMapping("{id}/update")
    public String updateTask(@PathVariable Long id, @ModelAttribute("updateTask") Task task) {
       taskService.updateTask(id, task);
       return "redirect:/api/tasks";
  }
  @GetMapping("{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/api/tasks";
  }
}
