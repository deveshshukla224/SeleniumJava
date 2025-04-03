import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;


public class ActionClassExample {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);

        //press SHIFT key and enter data
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click()
                .keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();


        //Mouse hover event
        action.moveToElement(driver.findElement
                (By.xpath("//a[starts-with(@href, 'https://www.amazon.com/ap/signin') and @data-csa-c-content-id='nav_ya_signin']"))
        ).contextClick().build().perform();

    }
}
