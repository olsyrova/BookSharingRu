package implementationsDAO;


import exceptions.PersistException;
import interfacesDAO.BookDAO;
import interfacesDAO.ImageDAO;
import interfacesDAO.ManagerDAO;
import junit.framework.Assert;
import objects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Property;
import utils.PropertyNames;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    private static BookDAO bookDao;
    private static ImageDAO imageDAO;

    @Before
    public void setUp() throws Exception {
        try {
            ManagerDAO managerDAO = new ManagerDAOImpl();
            Connection connection = managerDAO.getConnection();
            bookDao = managerDAO.getBookDAO(connection);
            imageDAO = managerDAO.getImageDAO(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getBooksByProperties() throws Exception{
        Property property = new Property(PropertyNames.TITLE, "чапаев и пустота");
        Property property1 = new Property(PropertyNames.AUTHOR_ID, "6");
        List<Property> list = new ArrayList<Property>();
        list.add(property);
        list.add(property1);
        List<Book> books = bookDao.getObjectsByProperties(list);
        Assert.assertNotNull(books);
    }


    @Test
    public void addNewBookTest() throws Exception {
        Book book = new Book("чапаев и пустота",2, 6, 1 );
        List<Image> images = new ArrayList<Image>();

        Set<Tag> tags = new HashSet<Tag>();
        tags.add(new Tag("fun"));
        tags.add(new Tag("joy"));
        tags.add(new Tag("fantasy"));
        images.add(new Image("/file/path/image1.png"));
        images.add(new Image("/file/path/image2.png"));
        book.setImages(images);
        book.setTags(tags);
        if (book.getTags().size()>0){
            // 1. check if tags are in the tags table already, if not add them, if yes return their ids

            // 2. add pairs book-id tag-id into book_tag_mapping

        }
        /*try {
            Book book1 = bookDao.persistObject(book);

            if (book.getImages().size()>0){
                for (Image image : book.getImages()){
                    image.setBook_id(book1.getId());
                }

            }
            imageDAO.persistBatch(book.getImages());

            List<Image> images2 = imageDAO.getImagesByBookID(book1.getId());
            Assert.assertNotNull(book1.getId() != -1);
            Assert.assertTrue(images2.size()>0);
            System.out.println(book1.toString());
        } catch (PersistException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}