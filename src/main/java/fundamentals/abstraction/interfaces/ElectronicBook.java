package fundamentals.abstraction.interfaces;

public class ElectronicBook implements Product, DigitalFile {
    private String name;
    private String author;
    private int pages;
    private String isbn;
    private String size;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSize() {
        return size;
    }
}
