package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_OrnekTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.navigate().to("https://www.testotomasyonu.com/");

        System.out.println("maximize gorunum size : " + driver.manage().window().getSize());
        System.out.println("maximize  gorunum position : " + driver.manage().window().getPosition());


        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(1000,500));
        Thread.sleep(3000);

        driver.quit();



    }
}
