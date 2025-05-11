package ra.model;

public class Task {
    int id;
    String description;
    String dueDate;
    boolean completed;

    public Task(boolean completed, String description, String dueDate, int id) {
        this.completed = completed;
        this.description = description;
        this.dueDate = dueDate;
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task() {
    }
}
