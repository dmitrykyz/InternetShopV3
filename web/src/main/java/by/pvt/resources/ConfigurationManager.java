package by.pvt.resources;

import java.util.ResourceBundle;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class ConfigurationManager {
    private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("config");
    //class retrieves information from a file config.properties
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
