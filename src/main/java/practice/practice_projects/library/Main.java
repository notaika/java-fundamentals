package practice.practice_projects.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("Java Library", "1478 IntelliJ Avenue", "09:00 - 17:00");
        // book tests

        // 📚 Sample books to seed your library
        library.getBooks().add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction"));
        library.getBooks().add(new Book("1984", "George Orwell", "Dystopian"));
        library.getBooks().add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic"));
        library.getBooks().add(new Book("Pride and Prejudice", "Jane Austen", "Romance"));
        library.getBooks().add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy"));
        library.getBooks().add(new Book("Moby-Dick", "Herman Melville", "Adventure"));
        library.getBooks().add(new Book("The Catcher in the Rye", "J.D. Salinger", "Young Adult"));
        library.getBooks().add(new Book("Brave New World", "Aldous Huxley", "Science Fiction"));
        library.getBooks().add(new Book("Jane Eyre", "Charlotte Brontë", "Gothic"));
        library.getBooks().add(new Book("Crime and Punishment", "Fyodor Dostoevsky", "Psychological Fiction"));

        library.run();
    }
}
