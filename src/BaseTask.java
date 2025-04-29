public abstract class BaseTask {
    protected int id;
    protected String description;
    protected boolean isCompleted;

    public BaseTask(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }

    public abstract String getDetail();

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }
}
