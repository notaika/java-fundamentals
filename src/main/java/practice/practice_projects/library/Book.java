package practice.practice_projects.library;

public class Book {
    private String title;
    private String author;
    private String genre;
    private static int count;
    private int id;
    private boolean isCheckedOut;

    public Book(String title, String author, String genre) {
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setId(); // using id's vs isbn for simplicity
        setCheckedOut(false);
    }

    public void setId() {
        count++;
        this.id = count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    // methods
}
