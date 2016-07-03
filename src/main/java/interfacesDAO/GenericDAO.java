package interfacesDAO;

import exceptions.PersistException;
import implementationsDAO.AbstractDAO;

import java.util.List;

/**
 * Created by olgasyrova on 02/07/16.
 */
public interface GenericDAO<T> {
    // get object by its id
    public T getObjectByID(int id) throws PersistException;

    // persist object to the database
    public T persistObject(T obj) throws PersistException;

    // update object in the database
    public void updateObject(T obj) throws PersistException;

    // delete object
    public void deleteObject(T obj) throws PersistException;

    // get all objects existing in the database table
    public List<T> getAllObjects() throws PersistException;


}
