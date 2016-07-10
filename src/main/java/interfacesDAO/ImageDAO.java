package interfacesDAO;

import objects.Book;
import objects.Image;

import java.util.List;

/**
 * Created by olgasyrova on 09/07/16.
 */
public interface ImageDAO extends GenericDAO<Image> {
    public List<Image> getImagesByBookID(int bookID);
}
