import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        //Scroll Window - No inbuilt function use JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)");
        Thread.sleep(3*1000);



        //ScrollInside a particular element
        //Step 1 : identify element from DOM using document.querySelector
        //Step 2 : Apply Scroll Method
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> actual_amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;

        for(int i=0;i<actual_amounts.size();i++){
            sum = sum +  Integer.parseInt(actual_amounts.get(i).getText());
        }

        String totalText = driver.findElement(By.cssSelector(".totalAmount")).getText();
        int total_value_on_page = Integer.parseInt(totalText.split(":")[1].trim());
        System.out.println("Total which is calculated "+sum);
        System.out.println("Total mentioned on Page "+total_value_on_page);
        Assert.assertEquals(sum,total_value_on_page);


    }
}
