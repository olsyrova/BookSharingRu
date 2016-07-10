package implementationsDAO;

import exceptions.PersistException;
import interfacesDAO.TagDAO;
import objects.Tag;
import objects.User;

import java.sql.*;
import java.util.List;

/**
 * Created by olgasyrova on 09/07/16.
 */
public class TagDAOImpl implements TagDAO{
    private Connection connection;

    public TagDAOImpl(Connection connection) {
        this.connection = connection;

    }



    public String getInsertQuery(){
        return "with s as (\n" +
                "    select id\n" +
                "    from tags\n" +
                "    where tag = ?\n" +
                "), i as (\n" +
                "    INSERT INTO tags (tag) \n" +
                "SELECT ? \n" +
                "WHERE NOT EXISTS(\n" +
                "\n" +
                "    SELECT id, tag\n" +
                "    FROM tags\n" +
                "    WHERE tag = ?\n" +
                ")\n" +
                "\n" +
                "RETURNING *\n" +
                ")\n" +
                "select id\n" +
                "from i\n" +
                "union all\n" +
                "select id\n" +
                "from s\n";
    }
    public String getInsertBookTagQuery(){
        return "insert into book_tag_mapping values(?,?)";
    }

    public String getRemoveAllTagsQuery(){
        return "delete from book_tag_mapping where book_id = ?";
    }

    public String getRemoveBookTagQuery(){
        return "delete from book_tag_mapping where book_id = ? AND tag_id = ?";
    }

    public void prepareStatementForInsert(PreparedStatement statement, Tag tag) {
        try {
            statement.setString(1, tag.getTag());
            statement.setString(2, tag.getTag());
            statement.setString(3, tag.getTag());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addNewTagIfNotExists(Tag tag) {
        int id = -1;
        String sql = getInsertQuery();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            prepareStatementForInsert(statement, tag);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id = rs.getInt(1);
            }

        } catch (SQLException pse){
            pse.printStackTrace();
        }
        return id;
    }

    public void addTagsToBook(int bookID, int[] tagIDs){
        PreparedStatement preparedStatement;
        String sql = getInsertBookTagQuery();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < tagIDs.length; i++){
                preparedStatement.setInt(1, bookID);
                preparedStatement.setInt(2, tagIDs[i]);
                preparedStatement.addBatch();
            }

            int[] count = preparedStatement.executeBatch();
            for (int i=0;i<count.length;i++){
                if (count[i] != 1) {
                    throw new PersistException("more than one object created");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    public void removeTagsFromBook(int bookID, int[] tagIDs){
        PreparedStatement preparedStatement;
        String sql = getRemoveBookTagQuery();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < tagIDs.length; i++){
                preparedStatement.setInt(1, bookID);
                preparedStatement.setInt(2, tagIDs[i]);
                preparedStatement.addBatch();
            }

            int[] count = preparedStatement.executeBatch();
            for (int i=0;i<count.length;i++){
                if (count[i] != 1) {
                    throw new PersistException("more than one object created");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    /*public void addTagToBook(int bookID, int tagID){
        PreparedStatement preparedStatement;
        String sql = getInsertBookTagQuery();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            preparedStatement.setInt(2, tagID);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new PersistException("more than one object created");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }*/



    @Override
    public void removeAllTagsForBook(int bookID) {
        PreparedStatement preparedStatement;
        String sql = getRemoveAllTagsQuery();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            int count = preparedStatement.executeUpdate();
            if (count != 1) {
                throw new PersistException("more than one object created");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tag getObjectByID(int id) throws PersistException {
        return null;
    }

    @Override
    public Tag persistObject(Tag obj) throws PersistException {
        return null;
    }

    @Override
    public void persistBatch(List<Tag> obj) throws PersistException {

    }

    @Override
    public void updateObject(Tag obj) throws PersistException {

    }

    @Override
    public void deleteObject(Tag obj) throws PersistException {

    }

    @Override
    public List<Tag> getAllObjects() throws PersistException {
        return null;
    }


}
