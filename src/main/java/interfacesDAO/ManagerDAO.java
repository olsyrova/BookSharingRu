package interfacesDAO;

import implementationsDAO.BookDAOImpl;
import implementationsDAO.UserDAOImpl;
import org.junit.Test;

import javax.naming.Context;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface ManagerDAO {


    public Connection getConnection() throws SQLException;

    public BookDAOImpl getBookDAO(Connection connection);

    public UserDAOImpl getUserDAO(Connection connection);

    //public GenericDAO getDAO(Context context, Class className) throws Exception;
}
