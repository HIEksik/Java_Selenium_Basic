package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_XPath_textKullanimi {
    public static void main(String[] args) throws InterruptedException {

        /*
        Bir web elementte yazı varsa genelde böyle kullanılır .. çünkü o yazı başka biryerde kullanılmamıştır
         */

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");


        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu=driver.findElement(By.xpath("//*[text()='Remove']"));

        if (removeButonu.isDisplayed()){
            System.out.println("Remove butonu görünme testi PASSED");
        }else {
            System.out.println("Remove butonu görünme testi FAILED");
        }


        //4- Delete tusuna basin
        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        //WebElement addRemoveYaziElementi=driver.findElement(By.tagName("h2"));
        WebElement addRemoveYaziElementi=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")); // sadece tag kullanılacaksa Tag ismi yeter

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add / Remove yazı Testi PASSED");
        }else {
            System.out.println("Add / Remove yazı Testi FAILED");
        }


        driver.quit();
    }
}
