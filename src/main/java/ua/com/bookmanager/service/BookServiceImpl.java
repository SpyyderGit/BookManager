package ua.com.bookmanager.service;

import ua.com.bookmanager.dao.BookDao;
import ua.com.bookmanager.model.Book;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Oleg on 05.04.2017.
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {

        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookId(int id) {

        return bookDao.getBookId(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }
}
