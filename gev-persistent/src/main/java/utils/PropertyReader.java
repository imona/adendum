package utils;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Monzer Masri on 21.11.2017.
 */

public class PropertyReader {
    private static PropertyReader ourInstance = new PropertyReader();
    private Properties mainProperties;

    private static PropertyReader getInstance() {
        return ourInstance;
    }

    private PropertyReader() {
        try {
            mainProperties = new Properties();
            String path = "./main.properties";
            FileInputStream file;
            file = new FileInputStream(path);

            mainProperties.load(file);
            file.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getAppProperty(String key) {
        return PropertyReader.getInstance().mainProperties.getProperty(key);
    }
}
