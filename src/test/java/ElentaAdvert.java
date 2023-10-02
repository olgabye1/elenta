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
        WebElement upload_file= driver.findElement(By.xpath("//*[@id=\"inputfile\"]"));
        upload_file.sendKeys("C:/Users/Olga/Desktop/tvarkytoja.jpeg");
        driver.findElement(By.id("forward-button")).click();


    }
    // Testo scenarijai
    //1.Kai ivedamas 2 simboliu pavadinimas;
    //2.Kai ivedamas >256 simboliu pavadinimas;
    //3.Kai ivedamas 5 simboliu skelbimas;
    //4.Kai ivedamas skelbimas tik skaitmenimis;
    //5.Kai neivedamas miestas (positive, nes neprivalomas laukas);
    //6.Kai miesto pavadinimas ivedamas su skaiciais/spec simboliais;
    //7.Kai ivedamas per ilgas tel.nr.
    //8.Kai ivedamas tel.nr.su spec.simboliais;
    //9.Kai ivedamas tel.nr.su raide gale;
    //10.Kai ivedamas el.pastas be @;
    //11. Kai ivedamas el.pastas .l (vietoj .lt)
    //12. kai ivedamas vieno skaiciaus/raides el.pastas, e.g.a@gmail.com
    //13.Kai neivedamas el.pastas (positive, nes neprivalomas laukas)).
    //14.kai neivedamas tel.nr.
    //15.kai neivedamas skelbimo aprasymas.
    //16.kai neivedamas Skelbimo pavadinimas.
    //17. kai skelbimo pavadinime ivedamas keiksmazodis "fuck";
    //18. kai skelbimo aprasyme ivedamas keiksmazodis "fuck";
    //19. kai skelbimo Miestas dalyje ivedamas keiksmazodis "fuck";
    //20.kai ivedami tik privalomi laukai (positive, nes neprivalomas laukas).










}
