package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Tag {
    private int id = -1;
    private String tag;


    public Tag(String tag){
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
