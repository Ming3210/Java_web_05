package ra.controller;

import ra.model.Student;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EditStudentController", value = "/edit-student")
public class EditStudentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = StudentController.findStudentById(id);

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("/view/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("students");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        Student updated = new Student(id, name, age, address);
        StudentController.updateStudent(updated);

        response.sendRedirect("students");
    }
}