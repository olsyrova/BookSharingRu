package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Category {
    private int id = -1;
    private String category;

    public Category(String category){
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
