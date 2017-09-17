package com.twu.biblioteca.model.command;

import com.twu.biblioteca.io.IOInterface;

public class KeyPad {

    private MainMenuCommand mainMenuCommand;
    private ListBooksCommand listBooksCommand;
    private ExitCommand exitCommand;
    private NoCommand noCommand;
    private RentBookCommand rentBookCommand;
    private ReturnBookCommand returnBookCommand;
    private ListMoviesCommand listMoviesCommand;
    private RentMovieCommand rentMovieCommand;
    private ViewUserInfoCommand viewUserInfoCommand;

    public KeyPad(IOInterface IO) {
        mainMenuCommand = new MainMenuCommand(IO);
        listBooksCommand = new ListBooksCommand(IO);
        exitCommand = new ExitCommand(IO);
        noCommand = new NoCommand(IO);
        rentBookCommand = new RentBookCommand(IO);
        returnBookCommand = new ReturnBookCommand(IO);
        listMoviesCommand = new ListMoviesCommand(IO);
        rentMovieCommand = new RentMovieCommand(IO);
        viewUserInfoCommand = new ViewUserInfoCommand(IO);
    }


    public void listBooks(){
        listBooksCommand.execute();
    }

    public void exit(){
        exitCommand.execute();
    }

    public void showMenu(){
        mainMenuCommand.execute();
    }

    public void showNoCommandErrorMsg(){
        noCommand.execute();
    }

    public void rentBook(){rentBookCommand.execute();}

    public void returnBook(){returnBookCommand.execute();}

    public void listMovies(){listMoviesCommand.execute();}

    public void rentMovie(){rentMovieCommand.execute();}

    public void viewUserInfo(){viewUserInfoCommand.execute();}
}
