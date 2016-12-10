package by.pvt.resources;

import java.util.ResourceBundle;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class MessageManager {
    private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("messages");
    //class retrieves information from a file messages.properties
    private MessageManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
