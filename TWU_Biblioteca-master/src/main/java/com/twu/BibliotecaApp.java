package com.twu;

import com.twu.biblioteca.io.ConsoleIO;
import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.command.KeyPad;
import com.twu.biblioteca.model.entity.Command;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.repo.Library;

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
            case Command.RENT_BOOK:
                keyPad.rentBook();
                keyPad.showMenu();
                break;
            case Command.RETURN_BOOK:
                keyPad.returnBook();
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
