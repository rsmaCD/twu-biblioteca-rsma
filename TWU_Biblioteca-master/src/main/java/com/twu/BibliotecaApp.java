package com.twu;

import com.twu.biblioteca.io.ConsoleIO;
import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.command.KeyPad;
import com.twu.biblioteca.model.entity.Command;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.repo.Library;
import com.twu.biblioteca.repo.MovieRepo;
import com.twu.biblioteca.repo.UserRepo;

public class BibliotecaApp {

    private IOInterface IO;

    private KeyPad keyPad;

    public BibliotecaApp(IOInterface IO) {
        this.IO = IO;
        this.keyPad = new KeyPad(IO);
    }

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        BibliotecaApp app = new BibliotecaApp(io);
        app.init(io);
        app.run();

    }

    public void init(IOInterface io) {
        io.Start();
        Library.getInstance().initLibrary();
        UserRepo.getInstance().initUserRepo();
        MovieRepo.getInstance().initMovieRepo();
        io.output(Constant.WELCOME_MSG);
    }

    public void run() {
        keyPad.showMenu();
        while (IO.getRunStatus()) {
            String input = IO.getInput();
            executeCommand(input);
        }
    }

    private void executeCommand(String input) {
        switch (input) {
            case Command.LIST_BOOKS:
                keyPad.listBooks();
                keyPad.showMenu();
                break;
            case Command.LIST_MOVIES:
                keyPad.listMovies();
                keyPad.showMenu();
                break;
            case Command.RENT_BOOK:
                keyPad.rentBook();
                keyPad.showMenu();
                break;
            case Command.RENT_MOVIES:
                keyPad.rentMovie();
                keyPad.showMenu();
                break;
            case Command.RETURN_BOOK:
                keyPad.returnBook();
                keyPad.showMenu();
                break;
            case Command.VIEW_USER_INFO:
                keyPad.viewUserInfo();
                keyPad.showMenu();
                break;
            case Command.Exit:
                keyPad.exit();
                break;
            default:
                keyPad.showNoCommandErrorMsg();
        }
    }
}
