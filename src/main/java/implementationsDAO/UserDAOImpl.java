package implementationsDAO;

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
    public String getUpdateQuery(User user) {
        return null;
    }

    @Override
    public String getDeleteQuery(User user) {
        return null;
    }

    @Override
    public void preparedStatementForDelete(PreparedStatement statement, User user) {

    }

    @Override
    public void prepareStatementForUpdate(PreparedStatement statement, User user) {

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

}
