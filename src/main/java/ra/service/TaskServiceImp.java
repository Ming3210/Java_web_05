package ra.service;

import ra.dao.TaskDAO;
import ra.dao.TaskDAOImp;
import ra.model.Task;

import java.util.List;

public class TaskServiceImp implements TaskService{
    private final TaskDAO taskDAO;


    public TaskServiceImp() {
        taskDAO = new TaskDAOImp();
    }

    @Override
    public List<Task> findAllTask() {
        return taskDAO.findAllTask();
    }

    @Override
    public Task findTaskById(int id) {
        return taskDAO.findTaskById(id);
    }

    @Override
    public void saveTask(Task task) {
        taskDAO.saveTask(task);
    }

    @Override
    public void updateTask(Task task) {
        taskDAO.updateTask(task);
    }

    @Override
    public void deleteTask(int id) {
        taskDAO.deleteTask(id);
    }
}
