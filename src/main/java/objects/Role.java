package objects;

/**
 * Created by olgasyrova on 03/07/16.
 * This class represents different roles of users in the application
 */
public enum Role {
    USER(1), MODERATOR(2), ADMINISTRATOR(3);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getValue() { return id; }

    public static Role getRoleByValue(int value){
        for(Role role : Role.values()){
            if( role.getValue() == value){
                return role;
            }
        }
        return null;
    }

}
