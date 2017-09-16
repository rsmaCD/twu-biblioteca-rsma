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

    private void outputNotice(){
        io.output(Constant.RETURN_BOOK_NOTICE);
    }

    private void outputWarning(){
        io.output(Constant.RETURN_BOOK_WARNING);
    }

    private void outputSuccessNotice(){
        io.output(Constant.RETURN_BOOK_SUCCESS_NOTICE);
    }

    @Override
    public void execute() {
        if(!CurrentUser.isCurrentUserLogin()){
            Login login = new Login(io);
            login.execute();
        }
        outputNotice();
        returnBook();
    }

    private void returnBook() {
        String bookName = io.getInput();
        if(libraryService.returnBook(bookName)){
            outputSuccessNotice();
        }else {
            outputWarning();
            returnBook();
        }
    }
}
