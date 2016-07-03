package objects;

/**
 * Created by olgasyrova on 29/06/16.
 */
public class User {

    private int id = -1;
    private String name;
    private String password;
    private String email;
    private Role role;
    private Age age;
    private String photoPath;
    private String location;
    private boolean banned = false;


    public User(){};

    public User(String username, String password, String email, Role role, Age age, String photoPath, String location){
        this.name = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.age = age;
        this.photoPath = photoPath;
        this.location = location;
    }

    // minimum constructor needed to create a new user
    public User(String username, String password, String email, Role role, Age age){
        this(username, password, email, role, age, null, null);
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isBanned(){
        return this.banned;
    }

    public void setStatus(boolean status){
        this.banned = status;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("user with id " + id + "\n");
        sb.append("email " + getEmail() + "\n");
        sb.append("status " + isBanned() + "\n");
        sb.append("role " + getRole().toString() + "\n");
        sb.append("location " + getLocation() + "\n");
        sb.append("age " + getAge() + "\n");
        return sb.toString();
    }
}
