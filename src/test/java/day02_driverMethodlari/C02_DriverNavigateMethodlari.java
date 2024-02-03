package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");

        WebDriver driver=new ChromeDriver();


        driver.navigate().to("https://testotomasyonu.com"); // get () ile aynı işlemi yapar

        // youtube anasayfaya gidin
        driver.navigate().to("https://youtube.com");

        // title ın YouTube içerdigini test edin
        String expectedTitleIcerik="YouTube";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title YouTube İçeriyor Test PASSED");
        }else {
            System.out.println("Title Youtube İçermiyor FAILED");
        }

        // tekrar test otomasyonu ana sayfaya dönün
        driver.navigate().back();

        // sayfa kaynagının "Test Otomasyonu " içerdigini test edin
        String expectedSayfaIcerik="Test Otomasyonu";
        String actualSayfaKaynagi=driver.getPageSource();

        if (actualSayfaKaynagi.contains(expectedSayfaIcerik)){
            System.out.println("Test Otomasyonu sayfa kaynagi testi PASSED");
        }else {
            System.out.println("Test Otomasyonu sayfa kaynagi testi FAILED");
        }

        // bir daha youtube anasayfaya gidin
        driver.navigate().forward();

        // url in https://www.youtube.com/ oldugunu test edin

        String expectedUrl="https://www.youtube.com/";
        String actualUrl=driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("YouTube Url testi PASSED");
        }else {
            System.out.println("YouTube Url testi FAILED");
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
