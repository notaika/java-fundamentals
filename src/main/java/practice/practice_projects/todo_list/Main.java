package practice.practice_projects.todo_list;

/*Small practice for myself to reinforce some data structures; mostly loops and collections

 * MVP:
 *   - ✅ Add a task (enter description)
 *   - ✅ View all tasks (show number and status)
 *   - ✅ Mark a task as done (by number)
 *   - ✅ Exit App

 * Extra Stuff I did:
 *  - ✅ Delete completed tasks
 *  - ✅ Track some stats*/

public class Main {
    public static void main(String[] args) {
        // create new todo app!
        TodoApp test = new TodoApp();

        // run app
        test.run();
    }
}
