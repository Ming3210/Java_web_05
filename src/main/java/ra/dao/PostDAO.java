package ra.dao;

import ra.model.Post;

import java.util.List;

public interface PostDAO {
    List<Post> findAllPost();
    Post findPostById(int id);
}
