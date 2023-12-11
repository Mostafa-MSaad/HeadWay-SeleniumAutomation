import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


//  Mouse Actions in Selenium:
//
//doubleClick(): Performs double click on the element
//clickAndHold(): Performs long click on the mouse without releasing it
//dragAndDrop(): Drags the element from one point and drops to another
//moveToElement(): Shifts the mouse pointer to the center of the element
//contextClick(): Performs right-click on the mouse
//Keyboard Actions in Selenium:
//
//sendKeys(): Sends a series of keys to the element
//keyUp(): Performs key release
//keyDown(): Performs keypress without release


public class actionClassEx {

        private WebDriver driver;

        String theInternetHerokuAppHomePageUrl = "https://the-internet.herokuapp.com/";

        // Element Locators
        private final By dragAndDropPage = By.xpath("//a[@href='/drag_and_drop']");
        private final By columnA = By.id("column-a");
        private final By columnB = By.id("column-b");
        private final By columnAHeader = By.cssSelector("div[id='column-a']>header");




    @Test
        public void dragAndDrop() {
            navigateToInternetHerokuAppHomePageUrl();
            dragAndDropPageFromHome();
            dragAndDropColumnAToB();
            checkDragAndDrop();
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
        public void dragAndDropPageFromHome() {
            driver.findElement(dragAndDropPage).click();

        }
    public void dragAndDropColumnAToB() {

        Actions a = new Actions(driver);
        a.dragAndDrop(driver.findElement(columnA), driver.findElement(columnB)).build().perform();

    }
    public void checkDragAndDrop() {
        Assert.assertEquals(driver.findElement(columnAHeader).getText(),"B");
    }


}
