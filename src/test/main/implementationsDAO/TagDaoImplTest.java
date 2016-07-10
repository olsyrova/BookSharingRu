package implementationsDAO;

import interfacesDAO.BookDAO;
import interfacesDAO.ManagerDAO;
import interfacesDAO.TagDAO;
import objects.Book;
import objects.Tag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by olgasyrova on 09/07/16.
 */
public class TagDaoImplTest {
    private static TagDAO tagDao;
    private static BookDAO bookDAO;

    @Before
    public void setUp() throws Exception {
        try {
            ManagerDAO managerDAO = new ManagerDAOImpl();
            Connection connection = managerDAO.getConnection();
            tagDao = managerDAO.getTagDAO(connection);
            bookDAO = managerDAO.getBookDAO(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addNewTagIfNotExistsTest(){
        Book book = new Book("чапаев и пустота",2, 6, 1 );
        book.setId(10);
        Set<Tag> tags = new HashSet<Tag>();
        tags.add(new Tag("magic"));
        //tags.add(new Tag("joy"));
        //tags.add(new Tag("fantasy"));
        book.setTags(tags);
        if (book.getTags().size() > 0){
            for (Tag tag : book.getTags()){
                // 1. check if tags are in the tags table already, if not add them, if yes return their ids
                int returnedTagID = tagDao.addNewTagIfNotExists(tag);
                // 2. add pairs book-id tag-id into book_tag_mapping
                //tagDao.addTagToBook(book.getId(), returnedTagID);
            }

        }
    }

    @Test
    public void addTagsForBookTest(){
        Book book = new Book("чапаев и пустота",2, 6, 1 );
        book.setId(10);
        int[] tagIDS = {2,3,4};
        Set<Tag> tags = new HashSet<Tag>();
        tags.add(new Tag("tag1"));
        tags.add(new Tag("tag2"));
        tags.add(new Tag("tag3"));
        book.setTags(tags);
        tagDao.addTagsToBook(book.getId(),tagIDS);

    }

    @Test
    public void removeTagsForBook(){
        Book book = new Book("чапаев и пустота",2, 6, 1 );
        book.setId(10);
        int[] tagIDS = {2,3};
        tagDao.removeTagsFromBook(book.getId(), tagIDS);
    }
}
