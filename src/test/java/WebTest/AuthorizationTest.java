package WebTest;

import Web.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AuthorizationTest extends AbstractTest{

@Test
void authorization() throws InterruptedException {

    Page page =new Page(getDriver());
    page.aut("GB202302d8e3c02","a4506abb71");
    try {
        Thread.sleep(1000);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    Assertions.assertEquals("https://test-stand.gb.ru/",getDriver().getCurrentUrl());

}
    @Test
    void authorization2() throws InterruptedException {
    Page page =new Page(getDriver());
    page.autPassword("a4506abb71");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertTrue(getDriver().getPageSource().contains("401"));

    }

    @Test
    void limitValues() throws InterruptedException {

    Page page = new Page(getDriver());
    page.aut("we","ff1ccf57e9");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertTrue(getDriver().getPageSource().contains("401"));

    }
    @Test
    void limitValues2() throws InterruptedException {

    Page page = new Page(getDriver());
    page.aut("dog","06d80eb0c5");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertEquals("https://test-stand.gb.ru/",getDriver().getCurrentUrl());

    }
    @Test
    void limitValues3() throws InterruptedException {
        Page page = new Page(getDriver());
        page.aut("ghjkmnbvcxsdfghjkl,mnbvxsdfghjkl,mnbvcdh","a49b62b132");
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertTrue(getDriver().getPageSource().contains("401"));

    }
    @Test
    void limitValues4() throws InterruptedException {
    Page page =new Page(getDriver());
    page.aut("qwertyuikjhgfdsazxcv","72def91854");

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Assertions.assertEquals("https://test-stand.gb.ru/",getDriver().getCurrentUrl());

    }
}
