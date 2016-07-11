package utils;

/**
 * Created by olgasyrova on 10/07/16.
 */
public class Property {
    private String propertyName;
    private String propertyValue;

    public String getPropertyName() {
        return propertyName;
    }


    public String getPropertyValue() {
        return propertyValue;
    }


    public Property(String propertyName, String propertyValue){
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

}
