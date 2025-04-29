public class Task extends BaseTask {

    public Task(int id, String description) {
        super(id, description); // use parent constructor
    }

    public String getDetail() {
        String status = isCompleted ? "[Completed]" : "[Pending]";
        return id + ". " + description + " " + status;
    }
}
