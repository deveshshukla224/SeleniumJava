import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FramesHandling {
    public static void main(String [] args){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/draggable/");
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        boolean dragable_element_visible = driver.findElement(By.id("draggable")).isDisplayed();
        System.out.println("Frame is switched and element is located"+dragable_element_visible);
//        action.moveToElement(driver.findElement(By.id("draggable")))
//                .dragAndDropBy(driver.findElement(By.id("draggable")),200,300).build().perform();
    }
}
