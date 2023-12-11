import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class automationExLinearDesign {

    private WebDriver driver;

    String automationExerciseHomePageUrl = "http://automationexercise.com";

    // Element Locators
    private final By homepage_featuredItemsTittle = By.xpath("(//h2[@class='title text-center'])[1]");
    private final By logInButton = By.xpath("//a[@href='/login']");
    private final By newUserSignupFormTittle = By.xpath("//div[@class='signup-form']//h2");
    private final By newUserSignupName = By.xpath("//input[@data-qa='signup-name']");
    private final By newUserSignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By newUserSignupButton = By.xpath("//button[@data-qa='signup-button']");
    private final By eNTERACCOUNTINFORMATIONTitle = By.xpath("//h2[@class='title text-center']//b");
    private final By titleRadioButtonMR = By.id("id_gender1");
    private final By password = By.id("password");
    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");
    private final By newsletterCheck = By.id("newsletter");
    private final By specialOffersCheck = By.id("optin");

    private final By firstname = By.id("first_name");
    private final By lastname = By.id("last_name");
    private final By company = By.id("company");

    private final By address1 = By.id("address1");

    private final By address2 = By.id("address2");
    private final By state = By.id("state");

    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile_number = By.id("mobile_number");
    private final By country = By.id("country");
    private final By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private final By aCCOUNTCREATEDMessage = By.xpath("//h2[@class='title text-center']//b");


    @Test
    public void TestCase1RegisterUser() {
        navigateToAutomationExerciseHomePageUrl();
        checkHomePageReached();
        reachLoginPageFromHomePage();
        checkLoginPageReached();
        signupFromLoginPage("Faker", "Faker@123.com");
        AddAccountInfo("12345a", 1,1,1,"Most","saad","gg","125","155",
                "gg","gg","123","12345");
        checkSignupPageReached();
        checkAccountCreated();
    }


    /////////////////////////// Configurations

    @BeforeMethod
    public void beforeMethod() {
        driver = new EdgeDriver();
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

    public void reachLoginPageFromHomePage() {
        driver.findElement(logInButton).click();
    }
    public void checkLoginPageReached() {
        Assert.assertEquals(driver.findElement(newUserSignupFormTittle).getText(),"New User Signup!");
    }


    public void signupFromLoginPage(String name,String Email) {
        driver.findElement(newUserSignupName).sendKeys(name);
        driver.findElement(newUserSignupEmail).sendKeys(Email);
        driver.findElement(newUserSignupButton).click();
    }
    public void checkSignupPageReached() {
   Assert.assertEquals(driver.findElement(eNTERACCOUNTINFORMATIONTitle).getText(),"ENTER ACCOUNT INFORMATION");
    }


    public void AddAccountInfo(String Password, int daysI, int monthsI, int yearsI, String fristName,String lastName,String Company,
                               String Address1,String Address2,String State,String City,String Zipcode,String Mobilenumber) {

        driver.findElement(titleRadioButtonMR).click();
        driver.findElement(password).sendKeys(Password);


        Select mySelect1= new Select(driver.findElement(days));
        mySelect1.selectByIndex(daysI);

        Select mySelect2= new Select(driver.findElement(months));
        mySelect2.selectByIndex(monthsI);

        Select mySelect3= new Select(driver.findElement(years));
        mySelect3.selectByIndex(yearsI);

        driver.findElement(newsletterCheck).click();
        driver.findElement(specialOffersCheck).click();


        driver.findElement(firstname).sendKeys(fristName);
        driver.findElement(lastname).sendKeys(lastName);
        driver.findElement(company).sendKeys(Company);

        driver.findElement(address1).sendKeys(Address1);
        driver.findElement(address2).sendKeys(Address2);
        driver.findElement(state).sendKeys(State);

        driver.findElement(city).sendKeys(City);
        driver.findElement(zipcode).sendKeys(Zipcode);
        driver.findElement(mobile_number).sendKeys(Mobilenumber);

        Select mySelect4= new Select(driver.findElement(country));
        mySelect4.selectByIndex(0);
        driver.findElement(createAccountButton).click();


    }
    public void checkAccountCreated() {
        Assert.assertEquals(driver.findElement(aCCOUNTCREATEDMessage).getText(),"ACCOUNT CREATED!");
}
}
