package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.ManagerDAO;
import interfacesDAO.UserDAO;
import junit.framework.Assert;
import objects.Age;
import objects.Book;
import objects.Role;
import objects.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class UserDAOImplTest {
    private UserDAO userDao;

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
            Assert.assertNotNull(user2.getId() != -1);
            System.out.println(user2.toString());
            System.out.println("was added to the database");
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void banUserTest() {
        try {
            // get random user
            User user1 = userDao.getObjectByID(19);
            userDao.banUser(user1, false);
            User user2 = userDao.getObjectByID(user1.getId());
            Assert.assertEquals(user2.isBanned(), false);
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllBooksByUserTest(){
        try {
            User user1 = userDao.getObjectByID(1);
            List<Book> bookList = userDao.getBooksAddedByUser(user1);
            Assert.assertNotNull(bookList);
            Assert.assertTrue(bookList.size() == 2);

        } catch (PersistException e){
            e.printStackTrace();
        }
    }

}