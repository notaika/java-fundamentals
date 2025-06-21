package practice.practice_projects.library;

public class Main {
    public static void main(String[] args) {
        Library test = new Library("Java Library", "1478 IntelliJ Avenue", "09:00 - 17:00");
//
//        test.run();

//        System.out.println(Integer.parseInt("90"));
//        String test = "34934";
//        System.out.println(String.valueOf("34924"));
//        System.out.println(test.charAt(0));



//        User testUser = new User("Matt", "matt@poop.ca", "poop1234");
//        test.addNewUser(1, testUser);
//        System.out.println(test.authenticateLogin(testUser.getEmail(), "poop"));
//        System.out.println(testUser.getPassword());

        for (int i = 1; i <= 10; i++) {
            String title = "title" + i;
            String author = "author" + i;
            String genre = "genre" + i;
            test.getBooks().add(new Book(title, author, genre));
        }

        for (Book book : test.getBooks()) {
            System.out.println(book.getId());
        }
    }
}
