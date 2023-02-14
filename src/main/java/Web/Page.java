package Web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Page extends AbstractPage{
    public Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"login\"]/div[1]/label")
    private WebElement login;

    @FindBy(xpath="//*[@id=\"login\"]/div[2]/label")
    private WebElement password;

    @FindBy(xpath="//*[@class=\"mdc-button__ripple\"]")
    private WebElement logIn;

    @FindBy(xpath="//*[@href=\"/?page=2\"]")
    private WebElement nextP;
    @FindBy(xpath="//*[@href=\"/?page=1\"]")
    private WebElement nextP1;

    public WebElement getNextP1() {
        return nextP1;
    }
    @FindBy(xpath="//*[@href=\"/posts/12386\"]")
    private WebElement post;

    public WebElement getPost() {
        return post;
    }

    public void aut(String log, String pass){
        Actions search = new Actions(getDriver());
        search.click(this.login)
                .sendKeys(this.login,log)
                .click(this.password)
                .sendKeys(this.password,pass)
                .click(this.logIn)
                .build()
                .perform();

    }
    public void nPage(){
        Actions search = new Actions(getDriver());
        search.click(this.nextP)
                .build()
                .perform();

    }

    public void autPassword (String password) {
        Actions search = new Actions(getDriver());
        search.click(this.password)
                .sendKeys(this.password,password)
                .click(this.logIn)
                .build()
                .perform();
    }
}
