package implementationsDAO;


import objects.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    //private static BookDao bookDao;

    @Before
    public void setUp() throws Exception {
    //    FactoryDao factoryDao = new DaoManagerImpl();
  //      Connection connection = factoryDao.getConnection();
//        bookDao = factoryDao.getBookDao(connection);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetAllBooks() throws Exception {
        //List<Book> allBooks = bookDao.getAllBooks();
       // assertTrue("total number of books is ", allBooks.size() == 1);
    }

    @Test
    public void testGetBookByID() throws Exception {
        //Book book = bookDao.getBookByID(9);
       // assertNotNull(book);
    }

    @Test
    public void testGetBooksByAuthor(Author author) throws Exception {

    }

    @Test
    public void testCreateNewBook() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}