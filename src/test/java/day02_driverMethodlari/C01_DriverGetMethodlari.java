package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        // Açılanan sayfanın title ında 'otomasyon' geçtiğini test edin




        String expectedTitleIcerik="otomasyon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("Title testi PASSED");
        }else {
            System.out.println("Title 'otomasyon' icermiyor, Title testi FAILED");
            System.out.println("Actual Title : "+actualTitle);
        }

        // Açılan sayfanın url nin otomasyon içerdigini test edin.

        String expectedUrlIcerik="otomasyon";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Url testi PASSED");
        }else {
            System.out.println("Url 'otomasyon' içermiyor, Test FAILED");
        }

        // driver ın gittigi sayfanın windowhanle degerini verir
        // driver oluşturulduktan sonra test boyunca açtıgı tüm sayfaların windowhandles degerlerini set olarak verir
        System.out.println(driver.getWindowHandle()); // 04606A7BDB8C03030079F1AEA7131FF1
        System.out.println(driver.getWindowHandles()); // [04606A7BDB8C03030079F1AEA7131FF1]

        System.out.println("================Sayfa kaynagı===========");
        System.out.println(driver.getPageSource()); // kaynak kodları gösterir




        Thread.sleep(3000);  // java dan gelir kodları yazılan milisaniye kadar bekletir

        driver.quit();



    }
}
