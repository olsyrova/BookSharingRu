package objects;

/**
 * Created by olgasyrova on 03/07/16.
 */
public enum Age {
    // 1 : "0-18", 2 : "19-35", 3 : "36-50", 4 : "50+"
    TEENAGER(1), YOUNG(2), ADULT(3), SENIOR(4);

    private final int value;
    Age(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Age getAgeByValue(int value){
        for(Age age : Age.values()){
            if( age.getValue() == value){
                return age;
            }
        }
        return null;
    }
}
