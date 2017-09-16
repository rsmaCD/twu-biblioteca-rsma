package com.twu.biblioteca.io;

import java.util.Scanner;

public class ConsoleIO implements IOInterface {

    @Override
    public void Start() {}

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void output(String output) {
        System.out.println(output);
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    @Override
    public boolean getRunStatus() {
        return true;
    }
}
