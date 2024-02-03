package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.TreeMap;

public class C03_TekrarTesti {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("WebDriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.navigate().to("https://www.youtube.com");

        String exceptedTitle="youtube";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(exceptedTitle)){
            System.out.println("youtube Başlık testi PASSED");
        }else {
            System.out.println("youtube Başlık testi FAILED");
            System.out.println("youtube Dogru başlık " + actualTitle);
        }

        Thread.sleep(3000);

        String exceptedUrl="youtube";
        String actualUrl=driver.getCurrentUrl();

        if (exceptedUrl.contains(actualUrl)){
            System.out.println("youtube Başlık testi PASSED");
        }else {
            System.out.println("youtube Başlık testi FAILED");
            System.out.println("youtube Dogru başlık " + actualTitle);
        }

        Thread.sleep(3000);

        driver.navigate().to("https://www.testotomasyonu.com/");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(3000);

        driver.navigate().forward();

        driver.manage().window().maximize();

        String exceptedTitleTest="Test";
        String actualTitleTest=driver.getTitle();

        if (actualTitleTest.contains(exceptedTitleTest)){
            System.out.println("Testotomasyonu  Başlık testi PASSED");
        }else {
            System.out.println("Testotomasyonu Başlık testi FAILED");
            System.out.println("Testotomasyonu Dogru başlık " + actualTitle);
        }

        String exceptedTitleTestUrl="https://testotomasyonu";
        String actualTitleTestUrl=driver.getTitle();

        if (actualTitleTestUrl.contains(exceptedTitleTestUrl)){
            System.out.println("Testotomasyonu  Url testi PASSED");
        }else {
            System.out.println("Testotomasyonu Url testi FAILED");
            System.out.println("Testotomasyonu Url Dogru başlık " + actualTitle);
        }

        Thread.sleep(3000);
        driver.quit();



    }
}
