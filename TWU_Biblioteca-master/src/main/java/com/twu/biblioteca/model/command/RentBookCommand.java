package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.service.LibraryService;

import static com.twu.biblioteca.model.entity.Constant.ALERT_NO_AVAIL_BOOKS;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_SUCCESS_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_WARNING;

/**
 * Created by rsma on 16/09/2017.
 */
public class RentBookCommand implements Command {

    private IOInterface io;

    private LibraryService libraryService = new LibraryService();

    public RentBookCommand(IOInterface io) {
        this.io = io;
    }

    private void outputNotice() {
        io.output(RENT_BOOK_NOTICE);
    }

    private void outputWarning() {
        io.output(RENT_BOOK_WARNING);
    }

    private void outputSuccessNotice() {
        io.output(RENT_BOOK_SUCCESS_NOTICE);
    }

    @Override
    public void execute() {
        if (!libraryService.isExistActiveBooks()) {
            outputNoActiveBooks();
        } else {
            outputNotice();
            rentBook();
        }
    }

    private void outputNoActiveBooks() {
        io.output(ALERT_NO_AVAIL_BOOKS);
    }

    private void rentBook() {
        String bookName = io.getInput();
        if (libraryService.rentBook(bookName)) {
            outputSuccessNotice();
        } else {
            outputWarning();
            rentBook();
        }
    }
}
