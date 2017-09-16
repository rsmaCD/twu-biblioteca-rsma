package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.model.enums.RentStatus;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Library {

    private static final Library library = new Library();
    private List<Book> books;

    public static Library getInstance() {
        return library;
    }

    private Library() {
    }

    public void initLibrary() {
        Book book1 = new Book(1, "book_1", "author_1", "2017-1-1", RentStatus.NOT_ON_RENT);
        Book book2 = new Book(2, "book_2", "author_2", "2017-1-2", RentStatus.NOT_ON_RENT);
        Book book3 = new Book(3, "book_3", "author_3", "2017-1-3", RentStatus.NOT_ON_RENT);
        Book book4 = new Book(4, "book_4", "author_4", "2017-1-4", RentStatus.ON_RENT);

        List<Book> books = asList(book1, book2, book3, book4);
        library.setBooks(books);
    }

    public List<Book> getActiveBooks(){
        return books
                .stream()
                .filter(book -> book.getRentStatus().equals(RentStatus.NOT_ON_RENT))
                .collect(Collectors.toList());
    }

    public List<Book> getInactiveBooks(){
        return books
                .stream()
                .filter(book -> book.getRentStatus().equals(RentStatus.ON_RENT))
                .collect(Collectors.toList());
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }

}
