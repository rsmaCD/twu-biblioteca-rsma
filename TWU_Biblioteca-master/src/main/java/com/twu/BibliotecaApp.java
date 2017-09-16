package com.twu;

import com.twu.biblioteca.io.ConsoleIO;
import com.twu.biblioteca.io.IOInterface;
import com.twu.biblioteca.model.entity.Constant;
import com.twu.biblioteca.model.entity.Command;
import com.twu.biblioteca.model.command.ExitCommand;
import com.twu.biblioteca.model.command.KeyPad;
import com.twu.biblioteca.model.command.ListBooksCommand;
import com.twu.biblioteca.model.command.MainMenuCommand;
import com.twu.biblioteca.model.command.NoCommand;
import com.twu.biblioteca.repo.Library;

public class BibliotecaApp {

    private IOInterface IO;

    private MainMenuCommand mainMenuCommand;
    private ListBooksCommand listBooksCommand;
    private ExitCommand exitCommand;
    private NoCommand noCommand;

    private KeyPad keyPad = new KeyPad();


    public BibliotecaApp(IOInterface IO) {
        this.IO = IO;

        mainMenuCommand = new MainMenuCommand(IO);
        listBooksCommand = new ListBooksCommand(IO);
        exitCommand = new ExitCommand(IO);
        noCommand = new NoCommand(IO);

        keyPad.setExitCommand(exitCommand);
        keyPad.setListBooksCommand(listBooksCommand);
        keyPad.setMainMenuCommand(mainMenuCommand);
        keyPad.setNoCommand(noCommand);
    }

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        BibliotecaApp app = new BibliotecaApp(io);
        init(io);
        app.run();

    }

    private static void init(ConsoleIO io) {
        Library.getInstance().initLibrary();
        io.output(Constant.WELCOME_MSG);
    }

    private void run() {
        keyPad.showMenu();
        while (true) {
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
            case Command.Exit:
                keyPad.exit();
                break;
            default:
                keyPad.showNoCommandErrorMsg();
        }
    }
}
