package day01_driverOlusturma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkOtomasyon {
    public static void main(String[] args) {

        /*
        1 - Web otomasyonu yapmak için oluşturdugumuz her Class ta bir web driver objesi oluşturmak zorundayız
        bu objeyi java konseptlerini kullanarak farklı şekillerde farklı şekillerde oluştura bilir
        veya inherit edebiliriz
        Ama web driver objesi olmadan test otomasyonu olmaz

        2 - Selenium son versiyonlarında kendi web driver ını oluşturdu
        Böylece System.setproperty() kullanmazsakta
        selenium kendi web driverı ile otomasyonu gerçekleştirir
        Şirketlerde kendi satınaldıkları WebDriver kullanma olasılıgı olacagından bizde bu satırı yazacagız

        3 - WebDriver driver=new ChromeDriver();
         satırını yazdığımızda , bir webdriver objesi oluşturulur
         bu obje sayesinde web driver methodlarını kullanabiliriz


         */

        System.setProperty("Webdriver.chrome.driver","src/kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

    }
}
