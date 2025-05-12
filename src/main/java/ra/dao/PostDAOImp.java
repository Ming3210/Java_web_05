package ra.dao;

import ra.model.Post;
import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImp implements PostDAO{
    @Override
    public List<Post> findAllPost() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Post> posts = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call findAllPosts()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setAuthor(rs.getString("author"));
                post.setPublishDate(rs.getString("publish_date"));
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return posts;
    }


    @Override
    public Post findPostById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Post post = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call findPostById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setAuthor(rs.getString("author"));
                post.setPublishDate(rs.getTimestamp("publish_date").toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return post;
    }

}
