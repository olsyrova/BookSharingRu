package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Author {
    private int id;
    private String authorName;

    // this constructor is used before the new author is persisted to the database (has no id yet)
    public Author(String authorName){
        this.id = -1;
        this.authorName = authorName;
    }

    // this constructor is used to create author object after extracting it from the database
    public Author(int id, String authorName){
        this.id = id;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }


}
