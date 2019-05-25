import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class searchTest {
    private WebDriver driver;
    private  ObjectBingoSearch test;
    private boolean expected = true;

    @BeforeMethod
    public void setUp(){
        //System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","/Users/greatkate/IdeaProjects/comBingo/src/main/resources/chromedriver 2");
        driver = new ChromeDriver();
        test = new ObjectBingoSearch(driver);
    }

    @Test
    public void searchReq01(){
        test.search("QA test engineers are wanted");
        Assert.assertEquals(test.successSearch(),expected );
        Assert.assertEquals(test.GettingFirstRequest("QA"),expected );

    }

    @Test
   public void searchReq02(){
        test.search("1234567890");
        Assert.assertEquals(expected, test.successSearch());
        Assert.assertEquals(test.GettingFirstRequest("1234567890"),expected );

    }


    @Test
    public void searchReq03(){
        test.search("Запрос на русском языке");
        Assert.assertEquals(expected, test.successSearch());
        Assert.assertEquals(test.GettingFirstRequest("Запрос"),expected );

    }

    @Test
    public void searchReq04(){
        test.search("!@#$%^&*()");
        Assert.assertEquals(expected, test.successSearch());
        Assert.assertEquals(test.GettingFirstRequest("!@#$%^&*()"),expected );
    }




    @AfterMethod (alwaysRun =  true)
    public void cookie(){

        driver.manage().deleteAllCookies();
        driver.close();
    }






}
