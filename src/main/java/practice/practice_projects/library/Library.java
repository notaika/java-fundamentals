package practice.practice_projects.library;
import fundamentals.abstraction.interfaces.Product;

import java.util.*;

public class Library {
    // fields
    private int idCount = 0;
    private List<Book> books;
    private Map<Integer, User> users;
    private String name;
    private String address;
    private String hours;

    private final Scanner scanner = new Scanner(System.in);
    // remember to close scanner please

    // constructor
    public Library(String name, String address, String hours) {
        setName(name);
        setAddress(address);
        setHours(hours);
        this.books = new ArrayList<>();
        this.users = new HashMap<>();
    }

    // getters and setters
    public int getIdCount() {
        return idCount;
    }

    public void incrementIdCount() {
        idCount++;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void addNewUser(Integer id, User user) {
        getUsers().put(id, user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void getMenu() {
        User activeUser = null;
        String input = "";

        while (activeUser == null && !input.equals("0")) {
            input = getInput("""
                ==================================
                * How would you like to proceed? *
                * 1 - Create an Account           *
                * 2 - Log in                      *
                * 0 - Exit                        *
                Enter your option:""");

            switch (input) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    activeUser = logInAccount();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
        while (activeUser != null && !input.equals("0")) {
            input = getInput("""
                ==================================
                * Welcome to your account!       *
                * 1 - Borrow a Book              *
                * 2 - Return a Book              *
                * 3 - Check your history         *
                * 4 - View all available books   *
                Enter your option:""");

            switch (input) {
                case "1":
                    borrowBook(activeUser);
                    break;
                case "2":
                    returnBook(activeUser);
                    break;
                case "3":
                    checkHistory(activeUser);
                    break;
                case "4":
                    viewAvailableBooks();
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please choose a valid option");
            }
        }
    }

    public void createAccount() {
        System.out.println("""
                =================================
                Creating a new library account...""");
        // get user info: name, email and password
        String userName = getInput("What is your name?");
        String userEmail = getInput("Enter your email.");
        String userPassword = getInput("Enter your password.");

        // create new user
        User newUser = new User(userName, userEmail, userPassword);
        incrementIdCount();

        // add new user to hashmap
        addNewUser(getIdCount(), newUser);
        System.out.printf("SUCCESS: Welcome %s! To access library features, please log in. Returning to main menu...%n", newUser.getName());
    }

    public User logInAccount() {
        System.out.println("""
                =================================
                Welcome back!
                Please enter your login details.""");
        String email = getInput("Enter your email");
        String password = getInput("Enter your password.");

        if (authenticateLogin(email, password) == null) {
            System.out.println("ERROR: Credentials did not match.");
            return null;
        };

        System.out.println("Successfully logged in.");
        return authenticateLogin(email, password);
    }

    public User authenticateLogin(String email, String password) {
        //for every user value in the users map...
        for (User user : users.values()) {
            // if arguments match an email & pass, return that user
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(User activeUser) {
        System.out.print("What is the ISBN of the book you'd like to checkout? ");
        int isbn = scanner.nextInt();
        scanner.nextLine();

        // in the list of books if isbn matches id... set checkout true and add to activeUser's history
        for (Book book : books) {
            if (isbn == book.getId()) {
                book.setCheckedOut(true);
                activeUser.borrowBook(book);

                System.out.printf("%s has been successfully checked out.%nReturning to main menu...", book.getTitle());
                return;
            }
        }

        System.out.println("Checkout was unsuccessful. Please try again.");
    }

    public void returnBook(User activeUser) {
        List<Book> userHistory = activeUser.getHistory();
        System.out.println("Getting User's History...");

        if (userHistory.isEmpty()) {
            System.out.println("You have no library history...");
        }

        for (Book book : userHistory) {
            if (book.isCheckedOut()) {
                System.out.printf("ID: %d | TITLE: %s | AUTHOR: %s%n", book.getId(), book.getTitle(), book.getAuthor());
            }
        }

        System.out.print("Enter the ID of the book to return: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();

        for (int i = userHistory.size() - 1; i >= 0 ; i--) {
            if (bookId == userHistory.get(i).getId()) {
                userHistory.get(i).setCheckedOut(false);
                activeUser.returnBook(userHistory.get(i));
                System.out.println("Successfully returned book");
                return;
            }
            System.out.println("ERROR: Could not return book");
        }

    }

    public void checkHistory(User activeUser) {
        List<Book> userHistory = activeUser.getHistory();
        for (Book book : userHistory) {
            System.out.printf("""
                    ID: %d | Genre: %s
                    Title: %s | Author: %s
                    Checked out? %b
                    """, book.getId(), book.getGenre(), book.getTitle(), book.getAuthor(), book.isCheckedOut());
        }
    }

    public void viewAvailableBooks() {
        List<Book> allBooks = getBooks();
        for (int i = 0; i < allBooks.size(); i++) {
            System.out.println("test");
        }
    }

    public void run() {
        getMenu();
    }
}
