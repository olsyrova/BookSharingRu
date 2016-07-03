package interfacesDAO;

import exceptions.PersistException;
import objects.Book;
import objects.User;

import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface UserDAO extends GenericDAO<User> {

    public void banUser(User user) throws PersistException;
    public List<Book> getBooksAddedByUser(User user);
    public List<Book> getBooksSavedByUser(User user);
    public List<Book> getBooksRequestedByUser(User user);

}
