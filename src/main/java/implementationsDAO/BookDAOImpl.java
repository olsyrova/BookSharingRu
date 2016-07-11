package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.BookDAO;
import interfacesDAO.ImageDAO;
import objects.*;
import sun.util.calendar.BaseCalendar;
import utils.Property;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by olgasyrova on 02/07/16.
 */
public class BookDAOImpl extends AbstractDAO<Book, Integer> implements BookDAO{

    public BookDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getLastAddedRowID() {
        return getSelectQuery() + " where id = currval('book_id_seq');";
    }

    @Override
    public String getInsertQuery() {
        return "insert into books values (nextval('book_id_seq'), ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM books ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE books ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM books WHERE title = ?;";
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, Book book) {
        try {
            statement.setString(1, book.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Book book) {

    }

    @Override
    public void preparedStatementForInsert(PreparedStatement statement, Book book) {
        // insert into books values (nextval('book_id_seq'), 'чапаев и пустота',1999,1,3,1,now(),null);
        try {
            statement.setString(1, book.getTitle());
            if (book.getYear() != null){
                statement.setInt(2,book.getYear());
            } else {
                statement.setNull(2, java.sql.Types.INTEGER);
            }
            statement.setInt(3, book.getCategoryID());
            statement.setInt(4, book.getAuthorID());
            statement.setInt(5, book.getOwner_id());
            statement.setTimestamp(6, book.getAdded_at());
            if (book.getPublishingHouseID()!=null){
                statement.setInt(7, book.getPublishingHouseID());
            } else {
                statement.setNull(7, java.sql.Types.INTEGER);
            }
            statement.setString(8, book.getDescription());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> parseResultSet(ResultSet rs) {
        List<Book> books = new ArrayList<Book>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setDescription(rs.getString("description"));
                book.setYear(rs.getInt("year"));
                book.setCategoryID(rs.getInt("category_id"));
                book.setAuthorID(rs.getInt("author_id"));
                book.setOwner_id(rs.getInt("added_by"));
                book.setAdded_at(rs.getTimestamp("added_at"));
                book.setPublishingHouseID(rs.getInt("publishing_house_id"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Image> getBookImages(Book book) {
        return null;
    }

    /*@Override
    public List<Image> getBookImages(Book book) {
        ImageDAO imageDAO = new ImageDAOImpl(connection);
        List<Image> images = imageDAO.getImagesByBookID(book.getId());
        book.setImages(images);
        return images;
    }*/


}
