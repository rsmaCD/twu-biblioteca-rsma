package com.twu.biblioteca.service;

import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.repo.Library;

import java.util.List;

public class LibraryService {

    private Library library = Library.getInstance();

    public List<Book> getAllActiveBooks() {
        return library.getActiveBooks();
    }

    public boolean rentBook(String bookName) {
        return library.rentBook(bookName);
    }

    public boolean returnBook(String bookName) {
        return library.returnBook(bookName);
    }

    public boolean isExistActiveBooks() {
        return library.getActiveBooks().size() != 0;
    }
}
