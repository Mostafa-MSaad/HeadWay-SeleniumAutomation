import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;



public class automationex {


        @Test()
         public void test(){
            WebDriver driver= new EdgeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("http://automationexercise.com");
            Assert.assertEquals(driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText(),"FEATURES ITEMS");

            driver.findElement(By.xpath("//a[@href='/login']")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//div[@class='signup-form']//h2")).getText(),"New User Signup!");

            driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Faker");
            driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Fake10@auto.com");
            driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='title text-center']//b")).getText(),"ENTER ACCOUNT INFORMATION");

            driver.findElement(By.id("id_gender1")).click();
            driver.findElement(By.id("password")).sendKeys("Faker1234");


            Select mySelect1= new Select(driver.findElement(By.id("days")));
            mySelect1.selectByIndex(0);

            Select mySelect2= new Select(driver.findElement(By.id("months")));
            mySelect2.selectByIndex(0);

            Select mySelect3= new Select(driver.findElement(By.id("years")));
            mySelect3.selectByIndex(0);

           // driver.findElement(By.xpath("//input[@id='newsletter']")).click();
            driver.findElement(By.id("newsletter")).click();
            //driver.findElement(By.xpath("//input[@id='optin']")).click();
            driver.findElement(By.id("optin")).click();


            driver.findElement(By.id("first_name")).sendKeys("Most");
            driver.findElement(By.id("last_name")).sendKeys("Saad");
            driver.findElement(By.id("company")).sendKeys("GG");

            driver.findElement(By.id("address1")).sendKeys("123");
            driver.findElement(By.id("address2")).sendKeys("456");
            driver.findElement(By.id("state")).sendKeys("GG");

            driver.findElement(By.id("city")).sendKeys("cairo");
            driver.findElement(By.id("zipcode")).sendKeys("12345");
            driver.findElement(By.id("mobile_number")).sendKeys("123456");

            Select mySelect4= new Select(driver.findElement(By.id("country")));
            mySelect4.selectByIndex(0);

            driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

            Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='title text-center']//b")).getText(),"ACCOUNT CREATED!");

            driver.quit();

        }

}
