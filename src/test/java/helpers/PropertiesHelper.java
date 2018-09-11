package helpers;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;

    public PropertiesHelper() throws IOException {
        FileReader reader = new FileReader("src/test/resources/application.properties");
        properties = new Properties();
        properties.load(reader);
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getKeyReadOnly() {
        return properties.getProperty("keyRO");
    }

    public static String getKeyReadWrite() {
        return properties.getProperty("keyRW");
    }

}
