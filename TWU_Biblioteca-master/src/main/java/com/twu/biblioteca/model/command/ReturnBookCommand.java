package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.service.LibraryService;

/**
 * Created by rsma on 16/09/2017.
 */
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
