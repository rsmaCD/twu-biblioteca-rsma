package com.twu.biblioteca.model.entity;

public class Constant {

    public static final String WELCOME_MSG = "Welcome to Biblioteca System !";

    public static final String MAIN_MENU_TEMPLETE = "******* Menu *******\n"
            +"1. List Books\n"
            + "2. Checkout Book\n"
            + "3. Return Book\n"
            + "4. Exit";

    public static final String ERROR_COMMAND_MSG = "Select a valid option!";

    public static final String ALERT_NO_AVAIL_BOOKS = "No available books in library!";

    public static final String RENT_BOOK_NOTICE = "Please input the name of book to checkout: ";
    public static final String RENT_BOOK_WARNING = "The book is not available.";
    public static final String RENT_BOOK_SUCCESS_NOTICE = "Thank you! Enjoy the book.";
    public static final String RETURN_BOOK_NOTICE = "Please input the name of book to return: ";
    public static final String RETURN_BOOK_WARNING = "That is not a available book to return.";
    public static final String RETURN_BOOK_SUCCESS_NOTICE = "Thank you for returning the book.";
}
