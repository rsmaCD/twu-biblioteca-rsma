package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.repo.CurrentUser;
import com.twu.biblioteca.service.LibraryService;

public class ReturnBookCommand implements Command{

    private IOInterface io;

    private LibraryService libraryService = new LibraryService();

    public ReturnBookCommand(IOInterface io) {
        this.io = io;
    }

    @Override
    public void execute() {
        if(!CurrentUser.getInstance().isCurrentUserLogin()){
            Login login = new Login(io);
            login.execute();
        }
        io.output(Constant.RETURN_BOOK_NOTICE);
        returnBook();
    }

    private void returnBook() {
        String bookName = io.getInput();
        if(libraryService.returnBook(bookName)){
            io.output(Constant.RETURN_BOOK_SUCCESS_NOTICE);
        }else {
            io.output(Constant.RETURN_BOOK_WARNING);
            returnBook();
        }
    }
}
