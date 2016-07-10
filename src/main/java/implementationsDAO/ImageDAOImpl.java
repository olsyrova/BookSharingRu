package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.BookDAO;
import interfacesDAO.ImageDAO;
import interfacesDAO.UserDAO;
import objects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olgasyrova on 09/07/16.
 */
public class ImageDAOImpl extends AbstractDAO<Image, Integer> implements ImageDAO {

    public ImageDAOImpl(Connection connection) {
        super(connection);
    }


    @Override
    public String getLastAddedRowID() {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return "insert into images values (nextval('images_id_seq'), ?, ?)";
    }

    @Override
    public String getSelectQuery() {
        return "select * from images ";
    }

    @Override
    public String getUpdateQuery(Image object) {
        return null;
    }

    @Override
    public String getDeleteQuery(Image object) {
        return null;
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, Image obj) {

    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, Image obj) {

    }

    @Override
    public void preparedStatementForInsert(PreparedStatement statement, Image image) {
        try {
            statement.setInt(1, image.getBook_id());
            statement.setString(2, image.getImagePath());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Image> parseResultSet(ResultSet rs) {
        List<Image> images = new ArrayList<Image>();
        try {
            while (rs.next()) {
                Image image = new Image();
                image.setId(rs.getInt("id"));
                image.setBook_id(rs.getInt("book_id"));
                image.setImagePath(rs.getString("image_path"));
                images.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    public List<Image> getImagesByBookID(int bookID) {
        List<Image> images = new ArrayList<Image>();
        String sql = getSelectQuery() + " WHERE book_id = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookID);
            ResultSet result = statement.executeQuery();
            images = parseResultSet(result);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return images;
    }

}
