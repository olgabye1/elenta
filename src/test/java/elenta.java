import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class elenta {
    public static WebDriver driver;

    @BeforeClass
    public void Login() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.findElement(By.id("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[2]/p")).click();


    }





}


