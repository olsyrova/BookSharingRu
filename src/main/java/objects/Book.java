package objects;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class Book {

    private int id = -1;
    private String title;
    private String description;
    private Integer year;
    private int authorID;
    private int categoryID;
    private Integer publishingHouseID;
    private Timestamp added_at;
    private int owner_id;
    private Set<Tag> tags;
    private List<Image> images;

    public Book(String title, String description, Integer year, int categoryID, int authorID, Integer publishingHouseID, int owner_id){
        this.title = title;
        this.description = description;
        this.year = year;
        this.authorID = authorID;
        this.categoryID = categoryID;
        this.publishingHouseID = publishingHouseID;
        this.owner_id = owner_id;
        Date date = new Date();
        this.added_at = new Timestamp(date.getTime());

    }

    public Book(String title, int categoryID, int authorID, int owner_id){
        this(title, null, null, categoryID, authorID, null, owner_id);

    }

    public Book(){}


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;

    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getPublishingHouseID() {
        return publishingHouseID;
    }

    public void setPublishingHouseID(Integer publishingHouseID) {
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("book with id " + id + "\n");
        sb.append("title " + getTitle() + "\n");
        sb.append("year " + getYear() + "\n");
        sb.append("author " + getAuthorID() + "\n");
        sb.append("was added by " + getOwner_id());
        sb.append("at " + getAdded_at() + "\n");
        return sb.toString();
    }


}
