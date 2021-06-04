package dataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties userdata;

    static {
        try {
            userdata = loadpro();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties loadpro () throws IOException {

        Properties pro = new Properties();
        InputStream inputStream = ConfigFileReader.class.getClassLoader()
                .getResourceAsStream("configuration.properties");
        pro.load(inputStream);
        return pro;
        }

    public static String getProperty(String key) {
        return ConfigFileReader.userdata.getProperty(key);
    }
}

