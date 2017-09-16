package com.twu.biblioteca.model.entity;

import com.twu.biblioteca.model.enums.RentStatus;

public class Book {

    private int bookId;
    private String bookName;
    private String author;
    private String publishDate;
    private RentStatus rentStatus;

    public Book(int bookId, String bookName, String author, String publishDate, RentStatus rentStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publishDate = publishDate;
        this.rentStatus = rentStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public RentStatus getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(RentStatus rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "  " + bookId +
                "  " + bookName +
                "  " + author +
                "  " + publishDate;
    }
}
