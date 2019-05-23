import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;






public class ObjectBingoSearch {
    private WebDriver driver;
    By searchField = By.xpath("//*[@id='sb_form_q']");
    By successMessageLocator = By.xpath("//*[@id='b_header']/nav/ul/li[1]/a");
    By firstElementInTheQueu = By.xpath("/html[1]/body[1]/div[2]/main[1]/ol[1]/li[1]/h2[1]/a[1]");
    WebDriverWait wait;
    WebElement element;

    public  ObjectBingoSearch (WebDriver driver){
        this.driver = driver;
        driver.get("https://www.bing.com/");
        wait = new WebDriverWait(driver,20);
        element  = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
    }

    public void search (String searchRequest){
        driver.findElement(searchField).sendKeys(searchRequest);
        driver.findElement(searchField).sendKeys(Keys.ENTER);

    }

    public boolean GettingFirstRequest (String expected){
        element  = wait.until(ExpectedConditions.visibilityOfElementLocated(firstElementInTheQueu));
        String ex = driver.findElement(firstElementInTheQueu).getText();
        ex = ex.toLowerCase();
        expected = expected.toLowerCase();
        boolean result = ex.contains(expected);
        return result;
    }


    public boolean successSearch(){
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
        return driver.findElement(successMessageLocator).isDisplayed();
    }



}
