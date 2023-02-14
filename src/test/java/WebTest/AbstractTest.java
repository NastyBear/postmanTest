package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class AbstractTest {

   // static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AbstractTest.class);

    private static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
         options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow(()->driver.navigate().to("https://test-stand.gb.ru/login"),"Страница недоступна");
    }

    @AfterAll
    static void close(){
      //  driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
