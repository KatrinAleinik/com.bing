import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SearchTest {
    private WebDriver driver;
    private ObjectBingoSearch test;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        test = new ObjectBingoSearch(driver);
    }

    @Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
    public void searchInput(String request, String result) {
        test.search(request);
        Assert.assertTrue("Search wasn't successful", test.successSearch());
        Assert.assertThat(test.gettingFirstRequest().toLowerCase(), CoreMatchers.containsString(result));
    }

    @AfterMethod(alwaysRun = true)
    public void cookie() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
