package WebTest;

import Web.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MePostTest extends AbstractTest{

    @Test
    void previousPage() {
        Page page = new Page(getDriver());
        page.aut("GB202302d8e3c02","a4506abb71");
        page.nPage();
        Actions search = new Actions(getDriver());
        search.click(page.getNextP1())
                .build()
                .perform();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertEquals("https://test-stand.gb.ru/?page=1",getDriver().getCurrentUrl());

    }
    @Test
    void nextPage3letters()  {

        Page page = new Page(getDriver());
        page.aut("dog","06d80eb0c5");

        Assertions.assertFalse(getDriver().getPageSource().contains("Next Page"));

    }

    @Test
    void post(){
        Page page = new Page(getDriver());
        page.aut("GB202302d8e3c02","a4506abb71");
        Actions search = new Actions(getDriver());
        search.click(page.getPost())
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getPageSource().contains("1"));
    }
    @Test
    void post2(){
        Page page = new Page(getDriver());
        page.aut("GB202302d8e3c02","a4506abb71");
        Actions search = new Actions(getDriver());
        search.click(page.getPost())
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getPageSource().contains("3"));
    }
    @Test
    void post3(){
        Page page = new Page(getDriver());
        page.aut("GB202302d8e3c02","a4506abb71");
        Actions search = new Actions(getDriver());
        search.click(page.getPost())
                .build()
                .perform();
        Assertions.assertTrue(getDriver().getPageSource().contains("http://test-stand.gb.ru/files/public/image/24d39faf04950732f9c35753cd24e132.png"));
    }

}
