package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.repo.CurrentUser;
import com.twu.biblioteca.service.LibraryService;

import static com.twu.biblioteca.model.entity.Constant.ALERT_NO_AVAIL_BOOKS;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_SUCCESS_NOTICE;
import static com.twu.biblioteca.model.entity.Constant.RENT_BOOK_WARNING;

public class RentBookCommand implements Command {

    private IOInterface io;

    private LibraryService libraryService = new LibraryService();
    private CurrentUser instance = CurrentUser.getInstance();
    private Login login ;

    public RentBookCommand(IOInterface io) {
        this.io = io;
        login = new Login(io);
    }

    @Override
    public void execute() {
        if(!instance.isCurrentUserLogin()){
            login.execute();
        }
        if (!libraryService.isExistActiveBooks()) {
            io.output(ALERT_NO_AVAIL_BOOKS);
        } else {
            io.output(RENT_BOOK_NOTICE);
            rentBook();
        }
    }

    private void rentBook() {
        String bookName = io.getInput();
        if (libraryService.rentBook(bookName)) {
            io.output(RENT_BOOK_SUCCESS_NOTICE);
        } else {
            io.output(RENT_BOOK_WARNING);
            rentBook();
        }
    }
}
