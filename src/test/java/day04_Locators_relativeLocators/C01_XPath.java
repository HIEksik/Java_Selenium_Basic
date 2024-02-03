package day04_Locators_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {
        //1- bir class olusturun
        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();
        //5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edin

        String expectedTitle="Test Otomasyonu";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title İçerik testi PASSED");
        }else  System.out.println("Title İçerik testi PASSED");



        //6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//li[@class='has-sub'])[5]")).click();

        Actions actions = new Actions(driver);

        for (int i = 0; i < 8; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        Thread.sleep(10000);

        //7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minumumdegerKutusu=driver.findElement(By.xpath("//input[@name='min']"));
        minumumdegerKutusu.clear();
        minumumdegerKutusu.sendKeys("40");

        WebElement maximumdegerKutusu=driver.findElement(By.xpath("//input[@name='max']"));
        maximumdegerKutusu.clear();
        maximumdegerKutusu.sendKeys("200");





        driver.findElement(By.xpath("//button[@name='button']")).click();





        //8- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunlerListesi=driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int actualBulunanUrunsayisi=bulunanUrunlerListesi.size();

        if (actualBulunanUrunsayisi>0){
            System.out.println("BulunanUrun Testi PASSED");
        }else  System.out.println("BulunanUrun Testi FAILED");

        //10-Ilk urunu tiklayin
        bulunanUrunlerListesi.get(0).click();

        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement urunFiyatElementi=driver.findElement(By.xpath("//span[@id='priceproduct']"));

        String urunfiyatiStr=urunFiyatElementi.getText().replaceAll("\\D","");

        int urunfiyati=Integer.parseInt(urunfiyatiStr)/100;

       if (urunfiyati>40 && urunfiyati<200){
           System.out.println("Ilk Urun Fiyatı testi PASSED");
       }else System.out.println("Ilk Urun Fiyatı testi FAILED");


       //12-Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }
}
