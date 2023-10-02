import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class ElentaAdvert {
    public static WebDriver driver;


    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.get("https://elenta.lt/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.className("fc-cta-consent")).click();
    }

    @Test
    public void addingAdvert () {
        driver.findElement(By.id("submit-new-ad-nav-button")).click();
        driver.findElement(By.xpath("//*[@id=\"select-top-category-list\"]/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"select-sub-category-list\"]/li[1]/a")).click();
        WebElement searchInput = driver.findElement(By.id("title"));
        searchInput.sendKeys("Siūlau darbą namų tvarkytojai");
        WebElement searchInput1 = driver.findElement(By.id("text"));
        searchInput1.sendKeys("Siūlau darbą namų tvarkytojai. Vieną kartą per savaitę, Vilniuje, Antakalnio soduose. Užtruksite iki 4-5h. Mokamas valandinis 10 EUR atlygis. Būtinos rekomendacijos");
        WebElement searchInput2 = driver.findElement(By.id("location-search-box"));
        searchInput2.sendKeys("Vilnius");
        WebElement searchInput3 = driver.findElement(By.id("phone"));
        searchInput3.sendKeys("+37067399255");
        WebElement searchInput4 = driver.findElement(By.id("email"));
        searchInput4.sendKeys("olga123@gmail.com");
        driver.findElement(By.id("submit-button")).click();









    }


}
