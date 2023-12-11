import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class First {
    public static void main(String[] args) {
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com/");

    }
}
