package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.service.LibraryService;

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
        io.output(Constant.RENT_BOOK_NOTICE);
    }

    private void outputWarning() {
        io.output(Constant.RENT_BOOK_WARNING);
    }

    private void outputSuccessNotice() {
        io.output(Constant.RENT_BOOK_SUCCESS_NOTICE);
    }

    @Override
    public void execute() {
        if (!libraryService.isExistActiveBooks()) {
            io.output(Constant.ALERT_NO_AVAIL_BOOKS);
        } else {
            outputNotice();
            rentBook();
        }
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
