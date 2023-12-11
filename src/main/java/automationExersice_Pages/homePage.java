package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class homePage {
    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    String automationExerciseHomePageUrl = "http://automationexercise.com";

    // Element Locators
    private final By homepage_featuredItemsTittle = By.xpath("(//h2[@class='title text-center'])[1]");
    private final By logInButton = By.xpath("//a[@href='/login']");

    //////Actions
    public void navigateToAutomationExerciseHomePageUrl() {driver.navigate().to(automationExerciseHomePageUrl);
    }

    public void checkHomePageReached() {

        Assert.assertEquals(driver.findElement(homepage_featuredItemsTittle).getText(),"FEATURES ITEMS");
    }

    public void reachLoginPageFromHomePage() {
        driver.findElement(logInButton).click();
    }
}
