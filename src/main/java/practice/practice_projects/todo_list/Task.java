package practice.practice_projects.todo_list;

public class Task {
    // fields to keep track of
    private boolean isCompleted = false;
    private String description;

    // constructor
    public Task(String description) {
        setDescription(description);
    }

    // getters & setters
    public boolean isCompleted() {
        return isCompleted;
    }
    // using setter to mark a task as done
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
