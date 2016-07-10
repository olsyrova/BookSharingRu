package interfacesDAO;

import implementationsDAO.AbstractDAO;
import objects.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface BookDAO extends GenericDAO<Book>{

    public Book getBookByTitle(String title);
    public List<Book> getBooksByCategory(Category category);
    public List<Book> getBooksByAuthor(Author author);
    public List<Book> getBooksByUser(User user);
    public List<Image> getBookImages(Book book);
    public List<Book> getBooksAddedAfter(Date timestamp);

}
