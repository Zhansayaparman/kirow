package melisova.kirow.models;

import javax.persistence.*;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long book_id;
    private String book_name;
    private String book_bagasy;
    private int time;
    private Author author;


    public Book() {
    }
    public Book(String book_name, String book_bagasy, int time) {
        this.book_name = book_name;
        this.book_bagasy = book_bagasy;
        this.time = time;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setbook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getbook_name() {
        return book_name;
    }

    public void setbook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_bagasy() {
        return book_bagasy;
    }

    public void setBook_bagasy(String book_bagasy) {
        this.book_bagasy = book_bagasy;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @ManyToOne
    @JoinColumn(name = "id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}
