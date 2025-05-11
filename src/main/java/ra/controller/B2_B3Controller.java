package ra.controller;

import ra.model.Person;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "B2Controller", value = "/B2Controller")
public class B2_B3Controller extends HttpServlet {
    private String message;


    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        Person person = new Person(name, age, address);


        // Validate the input
        if (name == null || name.isEmpty() || age == null || age.isEmpty() || address == null || address.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/b2_b3.jsp");
            dispatcher.forward(request, response);
            return;
        }
        try {
            Integer.parseInt(age);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Age must be a number.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/b2_b3.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (address.isEmpty()) {
            request.setAttribute("error", "Address must be at least 1 characters long.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/b2_b3.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (name.isEmpty()) {
            request.setAttribute("error", "Name must be at least 1 characters long.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/b2_b3.jsp");
            dispatcher.forward(request, response);
            return;
        }

        request.setAttribute("person", person);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/b2_confirm.jsp");
        dispatcher.forward(request, response);


    }

    public void destroy() {
    }
}