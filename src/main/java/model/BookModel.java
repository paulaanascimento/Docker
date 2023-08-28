package model;

public class BookModel {
    private final String name;
    private final String author;
    private final String releaseDate;
    private final String bookCode;

    public BookModel(String name, String author, String releaseDate, String bookCode) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.bookCode = bookCode;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBookCode() {
        return bookCode;
    }
}
