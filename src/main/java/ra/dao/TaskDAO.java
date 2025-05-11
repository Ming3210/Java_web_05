package ra.dao;

import ra.model.Task;

import java.util.List;

public interface TaskDAO {
    List<Task> findAllTask();
    Task findTaskById(int id);
    void saveTask(Task task);
    void updateTask(Task task);
    void deleteTask(int id);
}
