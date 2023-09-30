import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;


public class ELenta {
    public static WebDriver driver;

    @BeforeMethod
    public void BeforeMethod() {
        driver.get("https://elenta.lt/registracija");
    }


    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        driver.get("https://elenta.lt/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.className("fc-cta-consent")).click();

    }

    @Test
    public void registerPositiveTest() {
        int random = (int) Math.round(Math.random()*100000);
        WebElement searchInput = driver.findElement(By.id("UserName"));
        searchInput.sendKeys("zinkevio1"+random);
        WebElement searchInput2 = driver.findElement(By.id("Email"));
        searchInput2.sendKeys(random+"olga@gmail.com");
        WebElement searchInput3 = driver.findElement(By.id("Password"));
        searchInput3.sendKeys("Kodas123");
        WebElement searchInput4 = driver.findElement(By.id("Password2"));
        searchInput4.sendKeys("Kodas123");
        driver.findElement(By.id("bigNavBtn2")).click();
        String successMsg = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/p")).getText();
    }
    @Test
    public void registerNegativeTest1() {
        driver.findElement(By.id("UserName")).sendKeys("");
        driver.findElement(By.id("Email")).sendKeys("Olga@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Kodas123");
        driver.findElement(By.id("Password2")).sendKeys("Kodas123");
        driver.findElement(By.className("bigNavBtn2")).click();
        String errorMsg1 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span")).getText();
        Assert.assertEquals(errorMsg1,"Įveskite vartotojo vardą.");
    }
    @Test
    public void registerNegativeTest2() {
        driver.findElement(By.id("UserName")).sendKeys("olga111");
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("Kodas123");
        driver.findElement(By.id("Password2")).sendKeys("Kodas123");
        driver.findElement(By.className("bigNavBtn2")).click();
        String errorMsg2 = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span")).getText();
        Assert.assertEquals(errorMsg2, "Įveskite el. pašto adresą.");
    }
    @Test
    public void registerNegativeTest3() {
        int random3 = (int) Math.round(Math.random() * 100000);
        driver.findElement(By.id("UserName")).sendKeys("Olga111" + random3);
        driver.findElement(By.id("Email")).sendKeys(random3+"Olga@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("Password2")).sendKeys("Kodas123");
        driver.findElement(By.className("bigNavBtn2")).click();
        String errorMsg3 = driver.findElement(By.xpath("//*[@id=\"Password\"]")).getText();
        Assert.assertEquals(errorMsg3, "Įveskite slaptažodį.");
    }

    @Test
    public void registerNegativeTest4() {
        int random4 = (int) Math.round(Math.random() * 100000);
        driver.findElement(By.id("UserName")).sendKeys("Olga111" + random4);
        driver.findElement(By.id("Email")).sendKeys(random4 + "Olga@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Kodas123");
        driver.findElement(By.id("Password2")).sendKeys("");
        driver.findElement(By.className("bigNavBtn2")).click();
        String errorMsg4 = driver.findElement(By.xpath("//*[@id=\"Password2\"]")).getText();
        Assert.assertEquals(errorMsg4, "Pakartotinai neįvedėte slaptažodžio.");
    }


    }


