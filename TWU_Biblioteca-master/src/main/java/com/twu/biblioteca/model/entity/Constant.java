package com.twu.biblioteca.model.entity;

public class Constant {

    public static final String WELCOME_MSG = "Welcome to Biblioteca System !\n";

    public static final String MAIN_MENU_TEMPLETE = "******* Menu *******\n"
            +"1. List Books\n"
            + "2. Checkout Book\n"
            + "3. Return Book\n"
            + "4. Exit\n";

    public static final String ERROR_COMMAND_MSG = "Select a valid option!\n";

    public static final String ALERT_NO_AVAIL_BOOKS = "No available books in library.\n";

    public static final String RENT_BOOK_NOTICE = "Please input the name of book to checkout:\n";
    public static final String RENT_BOOK_WARNING = "The book is not available.\n";
    public static final String RENT_BOOK_SUCCESS_NOTICE = "Thank you! Enjoy the book.\n";
    public static final String RETURN_BOOK_NOTICE = "Please input the name of book to return:\n";
    public static final String RETURN_BOOK_WARNING = "That is not a available book to return.\n";
    public static final String RETURN_BOOK_SUCCESS_NOTICE = "Thank you for returning the book.\n";

    public static final String LOGIN_NOTICE = "Please login:\n";
    public static final String LOGIN_ERROR = "Library Number or password error.\n";
    public static final String LOGIN_SUCCESS_NOTICE = "Login success.\n";
    public static final String INPUT_LIBRARY_NUM_NOTICE = "Please input your library number:\n";
    public static final String INPUT_PASSWORD_NOTICE = "Please input your password:\n";
}
