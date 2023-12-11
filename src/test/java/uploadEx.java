import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class uploadEx {
    private WebDriver driver;

    String theInternetHerokuAppHomePageUrl = "https://the-internet.herokuapp.com/";

    // Element Locators
    private final By fileUploaderPage = By.xpath("//a[@href='/upload']");
    private final By chooseFileButton = By.id("file-upload");
    private final By submitButton = By.id("file-submit");
    private final By uploadedFile = By.xpath("//form[@method='POST']");


    @Test
    public void reachUserProfile() {
        navigateToInternetHerokuAppHomePageUrl();
        fileUploadPageFromHome();
        fileUpLoad();
        checkFileAndSubmit();
    }

    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {
        /// Browser options - Headless mode
        EdgeOptions options=new EdgeOptions();
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();


    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

//////////////////////////// Actions / Business steps ////////////

    public void navigateToInternetHerokuAppHomePageUrl() {
        driver.navigate().to(theInternetHerokuAppHomePageUrl);
    }
    public void fileUploadPageFromHome() {
        driver.findElement(fileUploaderPage).click();
    }
    public void fileUpLoad(){

        driver.findElement(chooseFileButton).sendKeys("D:\\Users\\mostafa.saad\\Desktop\\ForTesting.txt");
    }
    public void checkFileAndSubmit(){
     //   Assert.assertEquals(driver.findElement(uploadedFile).getText(), "ForTesting.txt");
        driver.findElement(submitButton).click();

    }
}
