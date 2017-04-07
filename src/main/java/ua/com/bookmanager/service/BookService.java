package ua.com.bookmanager.service;

import ua.com.bookmanager.model.Book;

import java.util.List;

/**
 * Created by Oleg on 05.04.2017.
 */
public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookId(int id);

    List<Book> listBooks();
}
