package ua.com.bookmanager.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.com.bookmanager.model.Book;


import java.util.List;

/**
 * Created by Oleg on 05.04.2017.
 */

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookDaoImpl.class);


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        LOGGER.info("Book successfully saved: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        LOGGER.info("Book successfully update. Vook detail: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        if (book.getId() == id) {
            session.delete(book);
        }

        LOGGER.info("Book successfully removed. Book details: " + book);

    }

    @Override
    public Book getBookId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        LOGGER.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from ua.com.bookmanager.model.Book").list();

        for (Book book : bookList) {
            LOGGER.info("Book list: " + book);
        }

        return bookList;
    }
}
