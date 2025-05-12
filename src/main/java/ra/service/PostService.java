package ra.service;

import ra.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPost();
    Post findPostById(int id);
}
