package interfacesDAO;

import implementationsDAO.AbstractDAO;
import objects.*;
import utils.Property;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by olgasyrova on 03/07/16.
 */
public interface BookDAO extends GenericDAO<Book>{

    public List<Image> getBookImages(Book book);

}
