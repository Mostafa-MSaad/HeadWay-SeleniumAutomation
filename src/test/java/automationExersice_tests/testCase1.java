package automationExersice_tests;

import automationExersice_Pages.confairmaccountCreated_page;
import automationExersice_Pages.enterAccountInfo_page;
import automationExersice_Pages.homePage;
import automationExersice_Pages.logInPage;
import frameWork_Engine.DriverFactory;
import frameWork_Engine.JsonFileManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class testCase1 {
    private static WebDriver driver;
    private homePage HomePage;
    private logInPage LogINPage;
    private enterAccountInfo_page EnterAccountInfo;
    private confairmaccountCreated_page ConfirmAccount;

    frameWork_Engine.JsonFileManager testData;

    @Test
    public void TestCase1RegisterUser() {

        HomePage.navigateToAutomationExerciseHomePageUrl();
        HomePage.checkHomePageReached();
        HomePage.reachLoginPageFromHomePage();
        LogINPage.checkLoginPageReached();
        LogINPage.signupFromLoginPage(testData.getTestData("test1.name"), testData.getTestData("test1.email"));
        EnterAccountInfo.checkSignupPageReached();
        EnterAccountInfo.AddAccountInfo(testData.getTestData("test1.password"), Integer.parseInt(testData.getTestData("test1.days")),
                Integer.parseInt(testData.getTestData("test1.months")), Integer.parseInt(testData.getTestData("test1.years")),
                testData.getTestData("test1.fristname"), testData.getTestData("test1.lastname"),
                testData.getTestData("test1.company"), testData.getTestData("test1.address1"),
                testData.getTestData("test1.address2"), testData.getTestData("test1.state"),
                testData.getTestData("test1.city"), testData.getTestData("test1.zipcode"),
                testData.getTestData("test1.mobile")
             );

        ConfirmAccount.checkAccountCreated();
    }


    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {
//        driver = new EdgeDriver();
//        driver.manage().window().maximize();
        driver = DriverFactory.initDriver();
        HomePage = new homePage(driver);
        LogINPage = new logInPage(driver);
        EnterAccountInfo = new enterAccountInfo_page(driver);
        ConfirmAccount = new confairmaccountCreated_page(driver);
      //  testData = new JsonFileManager("src/test/resources/TestData.json");

    }


    @AfterMethod
    public void afterMethod() {

        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        framework.engine.PropertiesReader.loadProperties();
        testData = new JsonFileManager("src/test/resources/TestData.json");
    }


}
