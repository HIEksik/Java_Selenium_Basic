package Odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    public static void main(String[] args) throws InterruptedException {
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        //3- Category bolumundeki elementleri locate edin
        WebElement categoriElement=driver.findElement(By.className("panel-heading"));

        //4- Category bolumunde 3 element oldugunu test edin
        List<WebElement> catagoriElementListi=driver.findElements(By.className("panel-heading"));

        int expectedElementSayisi=3;
        int actualElementSaytisi=catagoriElementListi.size();

        if (expectedElementSayisi==actualElementSaytisi){
            System.out.println("Catagory 3 element Testi PASSED");
        }else {
            System.out.println("Catagory 3 element Testi FAILED");
        }

        //5- Category isimlerini yazdirin
        for (WebElement each:catagoriElementListi
             ) {
            System.out.println(each.getText());
        }

        //6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();





    }
}
