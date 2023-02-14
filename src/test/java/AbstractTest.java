import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String keyAp;
    private static String urlPost;
    private static String urlGet;
    private static String urlGet2;
    private static String urlGetTest;
    private static String urlGet2Test;


    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/properties");
        prop.load(configFile);

        keyAp = prop.getProperty("key");
        urlPost= prop.getProperty("urlPost");
        urlGet = prop.getProperty("urlGet");
        urlGet2=prop.getProperty("urlGet2");
        urlGetTest=prop.getProperty("urlGetTest");
        urlGet2Test=prop.getProperty("urlGet2Test");
    }

    public static String getUrl(){
        return urlPost;
    }
    public static String getUrlGet(){
        return urlGet;
    }
    public static String getUrlGet2(){
        return urlGet2;
    }

    public static String getUrlGetTest() {
        return urlGetTest;
    }

    public static String getUrlGet2Test() {
        return urlGet2Test;
    }
}
