package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.ManagerDAO;
import interfacesDAO.UserDAO;
import objects.Age;
import objects.Role;
import objects.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDAOImplTest {
    UserDAO userDao;

    @Before
    public void setUp(){
        try {
            ManagerDAO managerDAO = new ManagerDAOImpl();
            Connection connection = managerDAO.getConnection();
            userDao = managerDAO.getUserDAO(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // test adding new user to the database
    @Test
    public void addNewUserToDatabaseTest(){
        // create new user
        User user = new User("tatiana","password","user@gmail.com", Role.USER, Age.SENIOR);
        try {
            User user2 = userDao.persistObject(user);
            System.out.println(user2.toString());
            System.out.println("was added to the database");
        } catch (PersistException e) {
            e.printStackTrace();
        }

    }
}