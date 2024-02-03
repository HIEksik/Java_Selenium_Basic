package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // test otomasyonu ana sayfaya gidin

        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın

        WebElement aramaKutusu=driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER); // aranacak kelimeyi gönder ve entere bas
       // aramaKutusu.submit(); entere basma


        // arama sonucunda bulunan elementlerin isimlerini yazdırın

        List<WebElement> bulunanUrunElementleriListi=driver.findElements(By.xpath("//a[@class='prod-title mb-3 ']"));
        /*
        Locate etmek için By.className methodu kullandıgımızda HTML elementteki Class attribute unun degerinde
        space varsa
        By.ClassName() methodu çalışmayabilir.
         */

        // Liste WebElementlerden oluştugu için listeyi direk yazdırırsak elementlerin referanslarını yazdırır
        // onun için foreach oluşturup eleementleri çekecegiz

        for (WebElement each:bulunanUrunElementleriListi
             ) {
            System.out.println(each.getText());
        }


        // arama sonucunda 4 ürün bulundugunu test edin

        int exceptedUrunsayisi=4;
        int actualUrunSayisi=bulunanUrunElementleriListi.size();

        if (exceptedUrunsayisi==actualUrunSayisi){
            System.out.println("Phone Arama Ürün Sayı Testi PASSED");
        }else {
            System.out.println("Phone Arama Ürün Sayı Testi FAILED");
        }


        // ilk ürün isminde case sensitive olmadan phone geçtiğini test edin

        String actualIlkUrunIsmi=bulunanUrunElementleriListi.get(0).getText().toLowerCase();

        String expectedUrunIcerik="phone";

        if (actualIlkUrunIsmi.contains(expectedUrunIcerik)){
            System.out.println("İlk urun ismi testi PASSED");
        }else {
            System.out.println("İlk urun ismi testi FAILED");
        }




        // sayfayi kapatın

        Thread.sleep(3000);
        driver.quit();




    }
}
