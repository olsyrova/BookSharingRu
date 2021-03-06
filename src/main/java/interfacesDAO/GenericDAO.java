package interfacesDAO;

import exceptions.PersistException;
import implementationsDAO.AbstractDAO;
import utils.Property;

import java.util.List;

/**
 * Created by olgasyrova on 02/07/16.
 */
public interface GenericDAO<T> {
    // get object by its id
    public T getObjectByID(int id) throws PersistException;

    // persist object to the database
    public T persistObject(T obj) throws PersistException;

    // persist a group of objs to the database
    public void persistBatch(List<T> obj) throws PersistException;

    // get objects by specified properties
    public List<T> getObjectsByProperties(List<Property> propertyList) throws PersistException;

    // update object in the database
    public void updateObject(T obj) throws PersistException;

    // delete object
    public void deleteObject(T obj) throws PersistException;

    // get all objects existing in the database table
    public List<T> getAllObjects() throws PersistException;


}
