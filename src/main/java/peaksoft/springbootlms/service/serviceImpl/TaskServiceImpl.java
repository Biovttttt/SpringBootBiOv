package peaksoft.springbootlms.service.serviceImpl;

import peaksoft.springbootlms.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springbootlms.repository.TaskRepository;
import peaksoft.springbootlms.service.TaskService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public void saveTask(Task task) {
taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task not found")
        );
    }

    @Override
    public void deleteTaskById(Long id) {
if (taskRepository.existsById(id)) {
    taskRepository.deleteById(id);
}else
    throw new RuntimeException("Task not found");
    }

    @Override
    public void updateTask(Long id, Task newTask) {
Task task=getTaskById(id);
task.setTaskName(newTask.getTaskName());
task.setTaskText(newTask.getTaskText());
task.setDeadLine(newTask.getDeadLine());
taskRepository.save(task);
    }
}
