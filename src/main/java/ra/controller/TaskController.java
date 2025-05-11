package ra.controller;

import ra.model.Task;
import ra.service.TaskService;
import ra.service.TaskServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TaskController", value = "/TaskController")
public class TaskController extends HttpServlet {
    private TaskService taskService;

    @Override
    public void init() {
        taskService = new TaskServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "findAll";
        }

        switch (action) {
            case "findAll":
                findAllTasks(request, response);
                break;
            case "edit":
                editTaskForm(request, response);
                break;
            case "delete":
                deleteTask(request, response);
                break;
            default:
                response.sendRedirect("view/error.jsp");
        }
    }

    private void findAllTasks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> taskList = taskService.findAllTask();
        request.setAttribute("taskList", taskList);
        request.getRequestDispatcher("view/b8.jsp").forward(request, response);
    }

    private void editTaskForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        Task task = taskService.findTaskById(taskId);
        request.setAttribute("task", task);
        request.getRequestDispatcher("view/editTask.jsp").forward(request, response);
    }

    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        taskService.deleteTask(taskId);
        findAllTasks(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("Create".equals(action)) {
            createTask(request, response);
        } else if ("Update".equals(action)) {
            updateTask(request, response);
        } else {
            response.sendRedirect("view/error.jsp");
        }
    }

    private void createTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        task.setDescription(request.getParameter("description"));
        task.setCompleted(Boolean.parseBoolean(request.getParameter("status")));
        taskService.saveTask(task);
        findAllTasks(request, response);
    }

    private void updateTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = new Task();
        task.setId(Integer.parseInt(request.getParameter("id")));
        task.setDescription(request.getParameter("description"));
        task.setCompleted(Boolean.parseBoolean(request.getParameter("status")));
        taskService.updateTask(task);
        findAllTasks(request, response);
    }

}
