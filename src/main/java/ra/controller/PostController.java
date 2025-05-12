package ra.controller;

import ra.dao.PostDAO;
import ra.dao.PostDAOImp;
import ra.model.Post;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "PostController", value = "/PostController")
public class PostController extends HttpServlet {
    private PostDAO postDAO;

    @Override
    public void init() {
        postDAO = new PostDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "findAll":
                List<Post> posts = postDAO.findAllPost();
                System.out.println("Posts fetched: " + posts.size());  // Thêm dòng này

                request.setAttribute("posts", posts);
                request.getRequestDispatcher("/view/b9.jsp").forward(request, response);
                break;

            case "findById":
                String idParam = request.getParameter("id");
                if (idParam != null) {
                    int id = Integer.parseInt(idParam);
                    Post post = postDAO.findPostById(id);
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("/view/post-detail.jsp").forward(request, response);
                } else {
                    response.sendRedirect("error.jsp");
                }
                break;

            default:
                response.getWriter().println("Unknown action: " + action);
        }
    }
}
