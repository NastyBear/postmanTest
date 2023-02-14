package Web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    public AbstractPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
}
