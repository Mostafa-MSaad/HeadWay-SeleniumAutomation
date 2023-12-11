
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.function.Function;

public class javaScriptExecuterEx {

        private WebDriver driver;

        String theInternetHerokuAppHomePageUrl = "https://the-internet.herokuapp.com/";

        // Element Locators
        private final By HoversPage = By.xpath("//a[@href='/hovers']");
        private final By user1Img = By.xpath("(//img[@alt='User Avatar'])[1]");
        private final By user1Profile = By.xpath("(//a[@href='/users/1'])[1]");
        private final By user1ProfilePageTitle = By.cssSelector("body>h1");





        @Test
        public void reachUserProfile() {
            navigateToInternetHerokuAppHomePageUrl();
            HoversPageFromHome();
            hoverImg();
            openUserProfile();
            checkProfilePageTitle();
        }

        @Test
        public void reachUserProfileUsingJavaScriptExecutor() {
            navigateToInternetHerokuAppHomePageUrl();
            HoversPageFromHome();
            openUserProfileJS();
            checkProfilePageTitle();

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
        public void HoversPageFromHome() {
            driver.findElement(HoversPage).click();

        }
        public void hoverImg() {
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(user1Img)).build().perform();

        }
    public void openUserProfile() {
        Wait<WebDriver> wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(user1Profile));
        driver.findElement(user1Profile).click();
    }


        public void checkProfilePageTitle() {
            Assert.assertEquals(driver.findElement(user1ProfilePageTitle).getText(),"Not Found");
        }
       public void openUserProfileJS() {

           JavascriptExecutor js = (JavascriptExecutor)driver;
           // Call the JavascriptExecutor methods
           js.executeScript("arguments[0].click();", driver.findElement(user1Profile));      }

    }
