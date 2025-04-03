import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowSwitching {
    public static void main(String []args){
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a[href*='documents-request']")).click();
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> IT = windows.iterator();
        String parentWindow = IT.next();
        String childWindow = IT.next();
        driver.switchTo().window(childWindow);
        String fullInfo = driver.findElement(By.cssSelector(".im-para.red")).getText();
        String[] emailpart = fullInfo.split("@");
        String[] smallInfo = emailpart[1].split("with");
        String[] emailwithdomain = smallInfo[0].split(".com");
        String actual_email = emailwithdomain[0];
        System.out.println("Email is "+actual_email);
        driver.switchTo().window(parentWindow);
        WebElement username_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        WebElement password_field = driver.findElement(By.id("password"));
        WebElement t_c_checkbox = driver.findElement(By.cssSelector("input#terms"));
        WebElement signInButton = driver.findElement(By.cssSelector("input[name='signin']"));
        username_field.sendKeys(actual_email);
        password_field.sendKeys("learning");
        t_c_checkbox.click();
        signInButton.click();



    }
}
