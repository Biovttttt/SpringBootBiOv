package peaksoft.springbootlms.service;

import peaksoft.springbootlms.entity.Task;

import java.util.List;

public interface TaskService {
    void saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    void deleteTaskById(Long id);
    void updateTask(Long id,Task newTask);
}
