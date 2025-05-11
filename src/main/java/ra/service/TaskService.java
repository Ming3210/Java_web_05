package ra.service;

import ra.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTask();
    Task findTaskById(int id);
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);
}
