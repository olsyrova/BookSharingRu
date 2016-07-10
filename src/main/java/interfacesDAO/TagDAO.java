package interfacesDAO;

import objects.Tag;

/**
 * Created by olgasyrova on 09/07/16.
 */
public interface TagDAO extends GenericDAO<Tag> {
    // returns id of existing tag if tag already existed or the newly created tag id if a tag was inserted
    public int addNewTagIfNotExists(Tag tag);

    //public void addTagToBook(int bookID, int tagID);

    public void addTagsToBook(int bookID, int[] tagID);

    public void removeTagsFromBook(int bookID, int[] tagID);

    public void removeAllTagsForBook(int bookID);
}
