package practice.practice_projects.library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private boolean isLoggedIn = false;
    private static int totalBorrowed;
    private List<Book> history;

    public User(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        this.history = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public List<Book> getHistory() {
        return history;
    }

    public void setHistory(List<Book> history) {
        this.history = history;
    }

    // methods
    public void borrowBook(Book book) {
        history.add(book);
    }

    public void returnBook(Book book) {
        book.setCheckedOut(false);
    }
}
