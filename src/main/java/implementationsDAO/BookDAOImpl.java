package implementationsDAO;

import interfacesDAO.BookDAO;
import objects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 02/07/16.
 */
public class BookDAOImpl extends AbstractDAO<Book, Integer> implements BookDAO{

    public BookDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getLastAddedRowID() {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM books ";
    }

    @Override
    public String getUpdateQuery(Book object) {
        return "UPDATE books ";
    }

    @Override
    public String getDeleteQuery(Book object) {
        return "DELETE FROM books WHERE title = ?;";
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, Book obj) {
        try {
            statement.setString(1, obj.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Book obj) {

    }

    @Override
    public void preparedStatementForInsert(PreparedStatement statement, Book obj) {

    }

    @Override
    public List parseResultSet(ResultSet rs) {
        return null;
    }


    @Override
    public Book getBookByTitle() {
        return null;
    }

    @Override
    public List<Book> getBooksByCategory(Category category) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return null;
    }

    @Override
    public List<Book> getBooksByUser(User user) {
        return null;
    }

    @Override
    public List<Book> getBooksAddedAfter(Date timestamp) {
        return null;
    }

    @Override
    public List<Book> getBooksAddedByPublishingHouse() {
        return null;
    }
}
