package day04_Locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C02_Relative_Locators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");

        //2 ) DSLR Camera’yi etrafindaki elementleri kullanarak 3 farkli relative
        //locator ile locate edip tiklayin
        //<img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">

        WebElement appleKulaklik=driver.findElement(By.id("pic6_thumb"));



        //3 ) Acilan urunun DSLR Camera oldugunu test edin.



        // 1. relative locate işlemi + click + test i ayrı ayrı yapalım
        WebElement dslrKamera1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(appleKulaklik));
        dslrKamera1.click();

        WebElement urunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String exceptedUrunIsmi="DSLR Camera";
        String actualUrunismi=urunIsimElementi.getText();

        if (actualUrunismi.equals(exceptedUrunIsmi)){
            System.out.println("1.Relative Locator Testi PASSED");
        }else  System.out.println("1.Relative Locator Testi FAILED");

        // 2. relative locate işlemi + click + test i ayrı ayrı yapalım
        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement motorTelefon=driver.findElement(By.id("pic8_thumb"));

        WebElement dslrCamera2=driver.findElement(RelativeLocator.with(By.id("pic7_thumb")).toLeftOf(motorTelefon));
        dslrCamera2.click();

        urunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        exceptedUrunIsmi="DSLR Camera";
        actualUrunismi=urunIsimElementi.getText();

        if (actualUrunismi.equals(exceptedUrunIsmi)){
            System.out.println("2.Relative Locator Testi PASSED");
        }else  System.out.println("2.Relative Locator Testi FAILED");


        // 3. relative locate işlemi + click + test i ayrı ayrı yapalım

        driver.get("https://testotomasyonu.com/relativeLocators");

        WebElement betKulaklik=driver.findElement(By.id("pic2_thumb"));

        WebElement dslrCamera3=driver.findElement(RelativeLocator.with(By.tagName("img")).below(betKulaklik));
        dslrCamera3.click();

        urunIsimElementi=driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        exceptedUrunIsmi="DSLR Camera";
        actualUrunismi=urunIsimElementi.getText();

        if (actualUrunismi.equals(exceptedUrunIsmi)){
            System.out.println("3.Relative Locator Testi PASSED");
        }else  System.out.println("3.Relative Locator Testi FAILED");



        Thread.sleep(3000);
        driver.quit();








    }
}
