package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.GenericDAO;
import objects.Book;

import javax.naming.event.ObjectChangeListener;
import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * Created by olgasyrova on 02/07/16.
 */
public abstract class AbstractDAO<T, PK extends Serializable> implements GenericDAO<T>{

    private final Connection connection;

    public AbstractDAO(Connection connection){
        this.connection = connection;
    }

    public abstract String getLastAddedRowID();
    public abstract String getInsertQuery();
    public abstract String getSelectQuery();
    public abstract String getUpdateQuery(T object);
    public abstract String getDeleteQuery(T object);
    public abstract void preparedStatementForDelete(PreparedStatement statement, T obj);
    public abstract void prepareStatementForUpdate(PreparedStatement statement, T obj);
    public abstract void preparedStatementForInsert(PreparedStatement statement, T obj);

    public abstract List<T> parseResultSet(ResultSet rs);

    public T getObjectByID(int primaryKey) throws PersistException {
        // get select query
        String sql = getSelectQuery() + " WHERE id = ?";
        PreparedStatement statement;
        List<T> resultList = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, primaryKey);
            ResultSet result = statement.executeQuery(sql);
            resultList = parseResultSet(result);

        } catch (SQLException e) {
            e.printStackTrace();

        }

        if ((resultList == null || resultList.size() == 0)){
            System.out.println("No object with this id in the database");
        } else if (resultList.size() > 1){
            throw new PersistException("Received more than one record.");
        }



        return resultList.iterator().next();
    }


    public List<T> getAllObjects() throws PersistException {
        List<T> resultList = null;
        String sql = getSelectQuery();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            resultList = parseResultSet(rs);
        } catch (Exception e){
            throw new PersistException("");
        }
        return resultList;
    }

    public void updateObject(T object) throws PersistException{
        String sql = getUpdateQuery(object);
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            prepareStatementForUpdate(statement, object);
            int numberOfRowsUpdated = statement.executeUpdate(sql);
            if (numberOfRowsUpdated != 1){
                throw new PersistException("more than one object updated");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteObject(T object) throws PersistException{
        String sql = getDeleteQuery(object);
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatementForDelete(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if (count!=1){
                throw new PersistException("more than one object deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T persistObject(T object) throws PersistException {
        // if object has an id it is already persisted
        /*if (object.getID() != null){
            throw new PersistException("object already exists in the database");
        }*/
        PreparedStatement preparedStatement;
        String sql = getInsertQuery();
        List<T> resultList = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatementForInsert(preparedStatement, object);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new PersistException("more than one object created");
            }
            // get newly inserted row from the database
            String sqlGet = getLastAddedRowID();
            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlGet);
            ResultSet result = preparedStatement2.executeQuery();
            resultList = parseResultSet(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if ((resultList == null || resultList.size() == 0)) {
            System.out.println("No object with this id in the database");
        } else if (resultList.size() > 1) {
            throw new PersistException("Received more than one record.");
        }
        return resultList.iterator().next();

    }


}
