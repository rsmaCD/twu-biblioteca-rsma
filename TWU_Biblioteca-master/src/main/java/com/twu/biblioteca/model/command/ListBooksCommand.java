package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Book;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.service.LibraryService;

import java.util.List;

public class ListBooksCommand implements Command {

    private LibraryService libraryService = new LibraryService();

    private IOInterface io;

    public ListBooksCommand(IOInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        ListBooks();
    }

    private void ListBooks() {
        if (!libraryService.isExistActiveBooks()) {
            io.output(Constant.ALERT_NO_AVAIL_BOOKS);
        } else {
            List<Book> allActiveBooks = libraryService.getAllActiveBooks();
            for (Book book : allActiveBooks) {
                io.output(book.toString());
            }
        }
    }
}
