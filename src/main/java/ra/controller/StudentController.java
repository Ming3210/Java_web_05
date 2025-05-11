package ra.controller;



import ra.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    private static List<Student> studentList = new ArrayList<>();
    private static int currentId = 1;
    private static final int STUDENTS_PER_PAGE = 2;


    private void initSampleData() {
        if (studentList.isEmpty()) {
            studentList.add(new Student(currentId++, "John Doe", 20, "123 Main St"));
            studentList.add(new Student(currentId++, "Jane Smith", 22, "456 Elm St"));
            studentList.add(new Student(currentId++, "Alice Johnson", 19, "789 Oak St"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initSampleData();
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            studentList.removeIf(s -> s.getId() == id);
            response.sendRedirect("students");
            return;
        }

        int totalStudents = studentList.size();
        int totalPages = (int) Math.ceil((double) totalStudents / STUDENTS_PER_PAGE);
        int currentPage = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("page"));
        } catch (NumberFormatException | NullPointerException ignored) {}

        if (currentPage < 1) currentPage = 1;
        if (currentPage > totalPages) currentPage = totalPages;

        int start = (currentPage - 1) * STUDENTS_PER_PAGE;
        int end = Math.min(start + STUDENTS_PER_PAGE, totalStudents);
        List<Student> currentList = studentList.subList(start, end);

        request.setAttribute("studentList", currentList);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.getRequestDispatcher("/view/b4_b5_b6_b7.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("students");
    }

    public static Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public static void updateStudent(Student updatedStudent) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == updatedStudent.getId()) {
                studentList.set(i, updatedStudent);
                return;
            }
        }
    }
}