package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class PublishingHouse {
    private int id = -1;
    private String publishingHouse;

    PublishingHouse(String publishingHouse){
        this.publishingHouse = publishingHouse;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }


}
