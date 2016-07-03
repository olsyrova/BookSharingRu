package objects;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Book {

    private int id;
    private String title;
    private int year;
    private int authorID;
    private int categoryID;
    private int publishingHouseID;
    private Timestamp added_at;
    private int owner_id;
    private Set<Tag> tags;
    private Set<Image> images;

    public Book(){}


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;

    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Timestamp getAdded_at() {
        return added_at;
    }

    public void setAdded_at(Timestamp added_at) {
        this.added_at = added_at;
    }

    public int getPublishingHouseID() {
        return publishingHouseID;
    }

    public void setPublishingHouseID(int publishingHouseID) {
        this.publishingHouseID = publishingHouseID;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }


}
