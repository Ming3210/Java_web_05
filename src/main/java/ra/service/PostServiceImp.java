package ra.service;

import ra.dao.PostDAO;
import ra.dao.PostDAOImp;
import ra.model.Post;

import java.util.List;

public class PostServiceImp implements PostService{
    private final PostDAO postDAO ;
    public PostServiceImp() {
        postDAO = new PostDAOImp();
    }

    @Override
    public List<Post> findAllPost() {
       return postDAO.findAllPost();
    }

    @Override
    public Post findPostById(int id) {
        return postDAO.findPostById(id);
    }
}
