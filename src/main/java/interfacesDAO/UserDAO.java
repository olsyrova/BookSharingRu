package interfacesDAO;

import exceptions.PersistException;
import objects.Book;
import objects.User;

import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface UserDAO extends GenericDAO<User> {

    // bans/unbans user according to the value set in status
    public void banUser(User user, boolean status) throws PersistException;
    public List<Book> getBooksAddedByUser(User user);
    public List<Book> getBooksSavedByUser(User user);
    public List<Book> getBooksRequestedByUser(User user);

}
