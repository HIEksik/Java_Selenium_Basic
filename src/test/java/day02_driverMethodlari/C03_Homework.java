package day02_driverMethodlari;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Homework {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.facebook.com");

        String exceptedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(exceptedTitle)){
            System.out.println("Facebook Başlık testi PASSED");
        }else {
            System.out.println("facebook Başlık testi FAILED");
            System.out.println("Dogru başlık " + actualTitle);
        }

        Thread.sleep(3000);

        driver.navigate().to("https://www.walmart.com");



        String exceptedTitleWalmart="Walmart.com";
        String actualTitleWalmart=driver.getTitle();

        if (exceptedTitleWalmart.contains(actualTitleWalmart)){
            System.out.println("Walmart Başlık testi PASSED");
        }else {
            System.out.println("walmart  Başlık testi FAILED");

        }

        Thread.sleep(3000);

        driver.navigate().back();

        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.quit();


    }
}
