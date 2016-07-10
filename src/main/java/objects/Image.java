package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Image {
    private int id = -1;
    private int book_id;
    private String imagePath;

    public Image(String imagePath){

        this.imagePath = imagePath;
    }

    public Image(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
