package fundamentals.abstraction.interfaces;

/*Create a Product interface
* Create a Book class that implements Product*/
public class Library {
    public static void main(String[] args) {
        Book myBook = new Book();
        myBook.setName("Mindset");
        String bookName = myBook.getName();

        double bookPrice = myBook.getPrice();

        System.out.println(bookName);
        System.out.println(bookPrice); // default 50....
    }
}
