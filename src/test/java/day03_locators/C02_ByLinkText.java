package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> sayfaLinkSayisi=driver.findElements(By.tagName("a"));
        int expectedLinkSayisi=147;
        int actualLinkSayisi=sayfaLinkSayisi.size();

        if (actualLinkSayisi==expectedLinkSayisi){
            System.out.println("Link testi PASSED");
        }else {
            System.out.println("Link testi FAILED");
        }

        //4- Products linkine tiklayin
       //  driver.findElement(By.linkText(" Products")).click();  Bu testte sorun oluyorsa Aşşagıdaki partialLinkText yapılsın
        driver.findElement(By.partialLinkText("Products")).click();//Link yazısının tamamı olmak zorunda degil bir parçası ile de çalışır


        //5- special offer yazisinin gorundugunu test edin
        WebElement specialOfferElementi=driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("Special Offer Yazı testti PASSED");
        }else {
            System.out.println("Special Offer Yazı testti FAILED");
        }


        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
