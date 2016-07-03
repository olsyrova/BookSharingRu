package interfacesDAO;

import implementationsDAO.AbstractDAO;
import objects.Author;
import objects.Book;
import objects.Category;
import objects.User;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface BookDAO extends GenericDAO<Book>{

    public Book getBookByTitle();
    public List<Book> getBooksByCategory(Category category);
    public List<Book> getBooksByAuthor(Author author);
    public List<Book> getBooksByUser(User user);
    public List<Book> getBooksAddedAfter(Date timestamp);
    public List<Book> getBooksAddedByPublishingHouse();

}
