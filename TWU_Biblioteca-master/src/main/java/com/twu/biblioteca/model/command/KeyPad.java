package com.twu.biblioteca.model.command;

public class KeyPad {

    private MainMenuCommand mainMenuCommand;
    private ListBooksCommand listBooksCommand;
    private ExitCommand exitCommand;
    private NoCommand noCommand;

    public void setMainMenuCommand(MainMenuCommand mainMenuCommand) {
        this.mainMenuCommand = mainMenuCommand;
    }

    public void setListBooksCommand(ListBooksCommand listBooksCommand) {
        this.listBooksCommand = listBooksCommand;
    }

    public void setExitCommand(ExitCommand exitCommand) {
        this.exitCommand = exitCommand;
    }

    public void setNoCommand(NoCommand noCommand) {
        this.noCommand = noCommand;
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
}
