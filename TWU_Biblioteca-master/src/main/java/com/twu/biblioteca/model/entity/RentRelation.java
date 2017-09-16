package com.twu.biblioteca.model.entity;

public class RentRelation {

    private String userName;
    private String bookName;

    public RentRelation() {
    }

    public RentRelation(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
