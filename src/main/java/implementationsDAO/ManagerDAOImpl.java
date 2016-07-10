package implementationsDAO;

import interfacesDAO.ManagerDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by olgasyrova on 29/06/16.
 */
public class ManagerDAOImpl implements ManagerDAO {

    public static final String url = "jdbc:postgresql:book_sharing_platform";
    public static final String password = "fuckyoutwo";
    public static final String user = "postgres";



    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public BookDAOImpl getBookDAO(Connection connection) {
        return new BookDAOImpl(connection);
    }

    @Override
    public UserDAOImpl getUserDAO(Connection connection) {
        return new UserDAOImpl(connection);
    }

    @Override
    public ImageDAOImpl getImageDAO(Connection connection) {
        return new ImageDAOImpl(connection);
    }

    @Override
    public TagDAOImpl getTagDAO(Connection connection) {
        return new TagDAOImpl(connection);
    }


}
