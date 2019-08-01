import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ObjectBingoSearch {

    @FindBy(id = "sb_form_q")
    private WebElement searchField;

    @FindBy(linkText = "All")
    private WebElement successMessageLocator;

    @FindBy(xpath = "//main[@aria-label='Search Results']//ol//li[1]//a")
    private WebElement firstElementInTheQueu;

    @FindBy(id = "sb_form_go")
    private WebElement submit;

    private WebDriverWait wait;

    public ObjectBingoSearch(WebDriver driver) {
        driver.get("https://www.bing.com/");
        wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
    }

    public void search(String searchRequest) {
        searchField.sendKeys(searchRequest);
        submit.click();
    }

    public String gettingFirstRequest() {
        wait.until(ExpectedConditions.elementToBeClickable(firstElementInTheQueu));
        return firstElementInTheQueu.getText();
    }


    public boolean successSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(successMessageLocator));
        return successMessageLocator.isDisplayed();
    }


}
