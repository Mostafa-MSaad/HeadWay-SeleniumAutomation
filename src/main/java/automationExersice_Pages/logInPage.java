package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class logInPage {
    private WebDriver driver;

    public logInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    private final By newUserSignupFormTittle = By.xpath("//div[@class='signup-form']//h2");
    private final By newUserSignupName = By.xpath("//input[@data-qa='signup-name']");
    private final By newUserSignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By newUserSignupButton = By.xpath("//button[@data-qa='signup-button']");

    //////actions
    public void checkLoginPageReached() {

        Assert.assertEquals(driver.findElement(newUserSignupFormTittle).getText(),"New User Signup!");
    }


    public void signupFromLoginPage(String name,String Email) {
        driver.findElement(newUserSignupName).sendKeys(name);
        driver.findElement(newUserSignupEmail).sendKeys(Email);
        driver.findElement(newUserSignupButton).click();
    }
}
