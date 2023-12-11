package automationExersice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class confairmaccountCreated_page {
    private WebDriver driver;

    public confairmaccountCreated_page(WebDriver driver) {
        this.driver = driver;
    }

    // Element Locators
    private final By aCCOUNTCREATEDMessage = By.xpath("//h2[@class='title text-center']//b");

    ///Validations
    public void checkAccountCreated() {

        Assert.assertEquals(driver.findElement(aCCOUNTCREATEDMessage).getText(),"ACCOUNT CREATED!");
    }
}
