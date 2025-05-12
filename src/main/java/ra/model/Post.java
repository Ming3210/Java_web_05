package ra.model;

public class Post {
    int id;
    String title;
    String content;
    String author;
    String publishDate;

    public Post(String author, String content, int id, String publishDate, String title) {
        this.author = author;
        this.content = content;
        this.id = id;
        this.publishDate = publishDate;
        this.title = title;
    }

    public Post() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
