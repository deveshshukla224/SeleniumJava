import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class AssignmentTwo {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector("a[href='/windows']"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.cssSelector("a[href='/windows/new']"))).click().build().perform();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> IT = windows.iterator();
        String parentWindow = IT.next();
        String childWindow = IT.next();
        driver.switchTo().window(childWindow);
        String textOfChild=driver.findElement(By.cssSelector(".example h3")).getText();
        driver.switchTo().window(parentWindow);
        String textOfParent = driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println("Child Window Text "+textOfChild);
        System.out.println("Parent Window Text "+textOfParent);

    }
}
