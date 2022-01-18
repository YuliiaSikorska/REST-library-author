package core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static final String APPLICATION_PROPERTIES_FILE = "application.properties";

    public static String getProperty(String propertyKey) {
        return readProperties().getProperty(propertyKey);
    }

    private static Properties readProperties() {
        Properties properties = new Properties();

        try (InputStream fileInputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
