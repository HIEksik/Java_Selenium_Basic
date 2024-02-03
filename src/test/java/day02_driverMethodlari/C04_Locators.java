package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.TreeMap;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testotomasyonu.com");

       WebElement aramaKutusu = driver.findElement(By.id("global-search")); // web element getirecek  By.id()

        // arama kutusuna phone yazıp aratalım ??

        aramaKutusu.sendKeys("phone");

        // aratma yapa bilmek için enter a basalım

        aramaKutusu.submit();

        // arama sonucunda ürün buluna bildigini test edin??

        WebElement aramaSonucElementi=driver.findElement(By.className("product-count-text"));


        // NoSuchElementException elementi bulamazsa bu excetionu verir

        System.out.println(aramaSonucElementi);
        // [[ChromeDriver: chrome on windows (0cfaa73efcdceab1c6361022b1403658)] -> class name: product-count-text] Referansını yazdı
        // arama sonuc elementinin data türü WebElement
        // WebElementler sout ile direkt yazdırılamaz // non-Primitiv oldugu için
        // get.Text() methodu ile web elemenet üzerindegki yazı alınabilir

        System.out.println(aramaSonucElementi.getText()); //4 Products Found

        String sonucYazisi=aramaSonucElementi.getText();

        sonucYazisi=sonucYazisi.replaceAll("\\D","");

        System.out.println(sonucYazisi);// "4"

        int sonucSayisi=Integer.parseInt(sonucYazisi);

        if (sonucSayisi>0){
            System.out.println("Arama testi PASSED");
        }else {
            System.out.println("Arama testi FAILED");
        }


        Thread.sleep(3000);
        driver.quit();



    }
}
