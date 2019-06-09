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


    @DataProvider (name = "testData")
    public Object [][] createData(){
        ReadExcelFile  config = new ReadExcelFile("/Users/greatkate/Documents/Java Apache files/JavaApacheExcel.xlsx");

        int rows = config.getRowCount(0);

        Object [] [] credentials = new Object[rows][2];

        for(int i =0; i<rows; i++){

            credentials[i][0]=config.getData(0, i, 0);
            credentials[i][1]=config.getData(0, i, 1);
        }

        return  credentials;
    }

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        //driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver","/Users/greatkate/IdeaProjects/comBingo/src/main/resources/chromedriver 2");
        driver = new ChromeDriver();
        test = new ObjectBingoSearch(driver);
    }

    @Test (dataProvider = "testData")
    public void searchInput(String request, String result) throws Exception{
        test.search(request);
        Assert.assertEquals(test.successSearch(),expected );
        Assert.assertEquals(test.GettingFirstRequest(result),expected );

    }





    @AfterMethod (alwaysRun =  true)
    public void cookie() throws Exception{

        driver.manage().deleteAllCookies();
        driver.close();
        //recorder.stop();
    }







}
