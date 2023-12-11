import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;


public class headlessExecutionScreenShotEx {
    private WebDriver driver;

    String automationExerciseHomePageUrl = "http://automationexercise.com";
    // Element Locators
    private final By homepage_featuredItemsTittle = By.xpath("(//h2[@class='title text-center'])[1]");


    @Test
    public void reachHomePage() {
        navigateToAutomationExerciseHomePageUrl();
        checkHomePageReached();
        takeScreenShot();

    }
    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {
        /// Browser options - Headless mode
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--headless");
        //options.setHeadless(true);
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();


    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

//////////////////////////// Actions / Business steps ////////////

    public void navigateToAutomationExerciseHomePageUrl() {
        driver.navigate().to(automationExerciseHomePageUrl);
    }
    public void checkHomePageReached() {
        Assert.assertEquals(driver.findElement(homepage_featuredItemsTittle).getText(),"FEATURES ITEMS");
    }
    public void takeScreenShot() {

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("D:\\Users\\mostafa.saad\\Desktop\\test.png"));

        } catch (IOException e) {
        }
    }



}
