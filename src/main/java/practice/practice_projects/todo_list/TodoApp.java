package practice.practice_projects.todo_list;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    // fields to keep track of in-app
    private ArrayList<Task> taskList = new ArrayList<>();
    private int tasksCreated;
    private int tasksCompleted;

    private final Scanner scanner = new Scanner(System.in);

    // getter & setters
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public int getTasksCreated() {
        return tasksCreated;
    }

    public void incrementTasksCreated() {
        tasksCreated++;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void incrementTasksCompleted() {
        tasksCompleted++;
    }

    /**
     * Runs and prints the main menu to interact with the program.
     * @return A boolean that handles if the menu loops
     */
    public boolean handleMenu() {
        int input = getMenuInput("""
                === TODO MENU ===
                1. Add Task
                2. View Tasks
                3. Mark Task as Done
                4. Delete All Completed Tasks
                5. Exit
                =================""");
        scanner.nextLine(); // clear line

        switch (input) {
            case 1: // add a task
                System.out.println("Describe your task:");
                String taskDescription = scanner.nextLine();
                addTask(taskDescription);
                incrementTasksCreated();
                break;
            case 2: // view tasks
                viewTasks();
                break;
            case 3: // mark the task as complete
                markCompletedTask();
                incrementTasksCompleted();
                break;
            case 4: // delete all completed tasks
                deleteCompletedTasks();
                break;
            case 5: // exit
                System.out.println("Goodbye!");
                return false;
            default:
                System.out.println("ERROR: Please enter a valid option.");
                break;
        }
        System.out.println("Press Enter to continue...");
        scanner.nextLine(); // intentional pause before next menu loop

        return true;
    }

    /**
     * Prints a prompt onto the console and returns the user input.
     * @param prompt A prompt to get user input
     * @return An int from user input
     */
    public int getMenuInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    /**
     * Adds a new task to the task list
     * @param description A string that describes the task
     */
    public void addTask(String description) {
        taskList.add(new Task(description));
        System.out.println("SUCCESS: A new task was added!");
        System.out.println("Task List size: " + taskList.size());
    }

    /**
     * Loops through taskList input and displays them on the console.
     * Tasks are marked with either [X] or [ ] to indicate completion status.
     * @param taskList An ArrayList of tasks
     */
    public void viewTasks() {
        System.out.printf("""
        ============== ALL TASKS ==============
        Total Created: %d | Total Completed: %d
        ---------------------------------------%n""", getTasksCreated(), getTasksCompleted());

        if (taskList.isEmpty()) {
            System.out.println("You currently have no tasks");
        }

        for (int i = 0; i < taskList.size(); i++) {
            Task currTask = taskList.get(i);

            if (currTask.isCompleted()) {
                System.out.printf("%d. [X] %s%n", (i + 1), currTask.getDescription());
            } else {
                System.out.printf("%d. [ ] %s%n", (i + 1), currTask.getDescription());
            }
        }
    }

    /**
     * Checks if user input is a valid index depending on the taskList.size().
     * If valid, successfully set isCompleted = true.
     */
    public void markCompletedTask() {
        System.out.println("Which task number did you complete?");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input >= 1 && input <= taskList.size()) {
            Task completedTask = taskList.get(input - 1);
            completedTask.setCompleted(true);

            System.out.printf("Successfully completed task!%n%d. %s%n", input, completedTask.getDescription());
        } else {
            System.out.println("ERROR: Not a valid task number. Heading back to menu...");
        }

    }

    /**
     * Loops through taskList backwards for safe removal.
     * Keeps count of deleted items and prints it with a success message.
     */
    public void deleteCompletedTasks() {
        int deleteCount = 0;

        for (int i = taskList.size() - 1; i >= 0; i--) {
            Task currTask = taskList.get(i);

            if(currTask.isCompleted()) {
                taskList.remove(i);
                deleteCount++;
            }
        }
        System.out.printf("SUCCESS: Deleted %d completed task(s) from task view.%n", deleteCount);
    }

    /**
     * Runs the whole user interactive portion of the app on the console.
     */
    public void run() {
        System.out.println("Welcome to your To-Do List");

        // get menu interface
        while (handleMenu());
    }
}