package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManegeMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        /*
        Görev odaklıdır.
        Sayfanın açılması veya kullanacağımız web elementlerin bulunması için
        Bekleyecegi maximum SÜREDİR.
        Görev odaklıdır , 10 saniyenin hepsini kullanmaz , İhtiyaç duydugunda 10 saniyeye kadar bekleme yapar.
        */
        Thread.sleep(3000);

        driver.manage().window().maximize(); // açılacak olan sayfayı tam sayfa yapar Sayfanın boyutu ile oynarız pixel cinsinden

        System.out.println("Maximize gorunum size : " + driver.manage().window().getSize());
        System.out.println("Maximize gorunum position : " + driver.manage().window().getPosition());

        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        System.out.println("FulScreen gorunum size : " + driver.manage().window().getSize());
        System.out.println("FullScreen gorunum position : " + driver.manage().window().getPosition());

        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(300,300));
        driver.manage().window().setSize(new Dimension(500,500));
        Thread.sleep(3000);

        System.out.println("Özel gorunum size : " + driver.manage().window().getSize());
        System.out.println("Özel gorunum position : " + driver.manage().window().getPosition());



        Thread.sleep(3000);// Görev odaklı degildir , 3 saniye mutlaka bekler
        driver.quit();



    }
}
