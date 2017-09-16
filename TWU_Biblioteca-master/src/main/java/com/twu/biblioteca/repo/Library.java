package com.twu.biblioteca.repo;

import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.model.enums.RentStatus;

import java.util.List;
import java.util.Optional;
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

    public List<Book> getActiveBooks() {
        return books
                .stream()
                .filter(book -> book.getRentStatus().equals(RentStatus.NOT_ON_RENT))
                .collect(Collectors.toList());
    }

    public List<Book> getInactiveBooks() {
        return books
                .stream()
                .filter(book -> book.getRentStatus().equals(RentStatus.ON_RENT))
                .collect(Collectors.toList());
    }

    public boolean rentBook(String bookName) {
        List<Book> books = getActiveBooks();
        if (!books.isEmpty()) {
            Optional<Book> book = books.stream().filter(bookTemp -> bookTemp.getBookName().equals(bookName)).findFirst();
            if (book.isPresent()) {
                book.get().setRentStatus(RentStatus.ON_RENT);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        List<Book> books = getInactiveBooks();
        if (!books.isEmpty()) {
            Optional<Book> book = books.stream().filter(bookTemp -> bookTemp.getBookName().equals(bookName)).findFirst();
            if (book.isPresent()) {
                book.get().setRentStatus(RentStatus.NOT_ON_RENT);
                return true;
            }
        }
        return false;
    }

    private void setBooks(List<Book> books) {
        this.books = books;
    }
}
