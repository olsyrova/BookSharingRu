package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.BookDAO;
import interfacesDAO.UserDAO;
import objects.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {

    public UserDAOImpl(Connection connection) {
        super(connection);

    }

    @Override
    public String getLastAddedRowID() {
        return "select * from users where id = currval('users_id_seq');";
    }

    @Override
    public String getInsertQuery() {
        return "insert into users values (nextval('users_id_seq'), ?, ?, ?, ?, ?, ?, ?, ?);";
    }


    @Override
    public String getSelectQuery() {
        return "select * from users ";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE users SET username=?,email=?,photo_path=?,location=?,banned=?,password_hash=?,age_id=? WHERE id= ?;";
    }

    @Override
    public String getDeleteQuery() {

        return "DELETE FROM users WHERE id=?";
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, User user) {
        try{
            statement.setInt(1, user.getId());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, User user) {
        try {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhotoPath());
            statement.setString(4, user.getLocation());
            statement.setBoolean(5, user.isBanned());
            statement.setString(6, user.getPassword());
            statement.setInt(7, user.getAge().getValue());
            statement.setInt(8, user.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void preparedStatementForInsert(PreparedStatement statement, User user) {
        // insert into users values (nextval('users_id_seq'), 'stephan','password','stephan@gmail.com',null,null,false,1,2);
        try {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhotoPath());
            statement.setString(5, user.getLocation());
            statement.setBoolean(6, user.isBanned());
            statement.setInt(7, user.getRole().getValue());
            statement.setInt(8, user.getAge().getValue());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> parseResultSet(ResultSet rs) {
        List<User> users = new ArrayList<User>();
        try {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhotoPath(rs.getString("photo_path"));
                user.setStatus(rs.getBoolean("banned"));
                user.setRole(Role.getRoleByValue(rs.getInt("role_id")));
                user.setAge(Age.getAgeByValue(rs.getInt("age_id")));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void banUser(User user, boolean status) throws PersistException {
        String sql = "UPDATE users SET banned = ? WHERE id = ?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, status);
            preparedStatement.setInt(2, user.getId());
            int count = preparedStatement.executeUpdate();
            if (count != 1){
                throw new PersistException("more than one row was updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooksAddedByUser(User user) {
        return null;
    }

    /*@Override
    public List<Book> getBooksAddedByUser(User user) {
        BookDAO bookDAO = new BookDAOImpl(connection);
        //List<Book> books = bookDAO.getBooksByUser(user);
        return books;
    }*/



    @Override
    public List<Book> getBooksSavedByUser(User user) {

        return null;
    }

    @Override
    public List<Book> getBooksRequestedByUser(User user) {
        return null;
    }
}
