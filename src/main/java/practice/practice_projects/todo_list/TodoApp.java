package practice.practice_projects.todo_list;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    // fields to keep track of in-app
    private ArrayList<Task> list = new ArrayList<>();
    private static int tasksCreated;
    private static int tasksCompleted;

    private final Scanner scanner = new Scanner(System.in);

    // getter & setters
    public ArrayList<Task> getTaskList() {
        return list;
    }

    public void setListDone(ArrayList<Task> taskList) {
        this.list = taskList;
    }

    public int getTasksCreated() {
        return tasksCreated;
    }

    public void setTasksCreated() {
        tasksCreated++;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted() {
        tasksCompleted++;
    }

    public int getMenuInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    /**
     * Adds a new task to the task list
     * @param description A string that describes the task
     * @param taskList An ArrayList of tasks
     */
    public void addTask(String description, ArrayList<Task> taskList) {
        //create a new task w/ description
        Task newTask = new Task(description);

        // add the task to the list
        taskList.add(newTask);
        System.out.println("SUCCESS: A new task was added!");
        System.out.println("Task List size: " + taskList.size());
    }

    public void viewTasks(ArrayList<Task> taskList) {
        // track total # of stats created and completed as static field of app
        System.out.printf("""
        ============== ALL TASKS ==============
        Total Created: %d | Total Completed: %d
        ---------------------------------------%n""", getTasksCreated(), getTasksCompleted());

        // empty task list message
        if (taskList.isEmpty()) {
            System.out.println("You currently have no tasks");
        }

        // print [X] if completed, [ ] if not; couldn't figure out a better way to do this
        for (int i = 0; i < taskList.size(); i++) {
            Task currTask = taskList.get(i);

            if (currTask.isCompleted()) {
                System.out.printf("%d. [X] %s%n", (i + 1), currTask.getDescription());
            } else {
                System.out.printf("%d. [ ] %s%n", (i + 1), currTask.getDescription());
            }
        }
    }

    public void markCompletedTask(ArrayList<Task> taskList) {
        // prompt and input to get which task to mark as complete
        System.out.println("Which task number did you complete?");
        int input = scanner.nextInt();
        scanner.nextLine();

        // validation; make sure it's within range of taskList size
        if (input >= 0 && input < taskList.size()) {
            Task completedTask = taskList.get(input - 1);
            completedTask.setCompleted(true);

            System.out.printf("Successfully completed task!%n%d. %s%n", input, completedTask.getDescription());
        } else {
            System.out.println("ERROR: Not a valid task number. Heading back to menu...");
        }

    }

    public void deleteCompletedTasks(ArrayList<Task> taskList) {
        // keep count of deleted tasks
        int deleteCount = 0;

        // delete task if isCompleted = true
        for (int i = taskList.size() - 1; i >= 0; i--) {
            Task currTask = taskList.get(i);

            if(currTask.isCompleted()) {
                taskList.remove(i);
                deleteCount++;
            }
        }
        System.out.printf("SUCCESS: Deleted %d completed task(s) from task view.%n", deleteCount);
    }

    public void run() {
        ArrayList<Task> taskList = getTaskList();
        int input;

        System.out.println("Welcome to your To-Do List");

        // get menu interface
        do {
            input = getMenuInput("""
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
                    addTask(taskDescription, taskList);
                    setTasksCreated();
                    scanner.nextLine(); // clear line
                    break;
                case 2: // view tasks
                    viewTasks(taskList);
                    scanner.nextLine(); // clear line
                    break;
                case 3: // mark the task as complete
                    markCompletedTask(taskList);
                    setTasksCompleted();
                    scanner.nextLine(); // clear line
                    break;
                case 4: // delete all completed tasks
                    deleteCompletedTasks(taskList);
                    scanner.nextLine();
                    break;
                case 5: // exit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("ERROR: Please enter a valid option.");
                    scanner.nextLine(); // clear line
                    break;
            }

        } while (input != 5);
    }
}