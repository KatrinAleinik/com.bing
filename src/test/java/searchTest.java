import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import atu.testrecorder.ATUTestRecorder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class searchTest {
    private WebDriver driver;
    private  ObjectBingoSearch test;
    private boolean expected = true;
    //ATUTestRecorder recorder;


    @DataProvider (name = "validInput")
    public Object [] [] createValidData(){
        return new Object[][]{
                {"Portnov computer school", "Portnov"},
                {"Запрос на русском языке", "русском"},
                {"1234567890", "1234567890"},
        };
    }

    @DataProvider (name = "invalidInput")
    public Object [][] createInvalidData(){
        return new Object [][]{
                {"!@#$%^&*()", "!@#$%^&*()"},
        };
    }

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        //driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver","/Users/greatkate/IdeaProjects/comBingo/src/main/resources/chromedriver 2");
        driver = new ChromeDriver();
        test = new ObjectBingoSearch(driver);
    }

    @Test (dataProvider = "validInput")
    public void searchValidInput(String request, String result) throws Exception{
        test.search(request);
        Assert.assertEquals(test.successSearch(),expected );
        Assert.assertEquals(test.GettingFirstRequest(result),expected );

    }

    @Test (dataProvider = "invalidInput")
    public void searchInvalidInput(String request, String result) throws Exception{
        test.search(request);
        Assert.assertEquals(expected, test.successSearch());
        Assert.assertEquals(test.GettingFirstRequest(result),expected );
    }




    @AfterMethod (alwaysRun =  true)
    public void cookie() throws Exception{

        driver.manage().deleteAllCookies();
        driver.close();
        //recorder.stop();
    }







}
