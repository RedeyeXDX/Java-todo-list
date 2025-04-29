import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TODO LIST MENU ---");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Edit task description");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    editTaskDescription(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task newTask = new Task(nextId, description);
        tasks.add(newTask);
        nextId++;
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n--- Your Tasks ---");
        for (Task task : tasks) {
            String status = task.isCompleted() ? "[Completed]" : "[Pending]";
            System.out.println(task.getId() + ". " + task.getDescription() + " " + status);
        }
    }

    // Method with parameter — meets requirement
    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter task ID to mark as completed: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markAsCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Another method with parameter — meets requirement
    private static void editTaskDescription(Scanner scanner) {
        System.out.print("Enter task ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new description: ");
                String newDesc = scanner.nextLine();
                task.setDescription(newDesc);
                System.out.println("Task updated.");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
