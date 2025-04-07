import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AssignmentFive {

        public static void main(String[] args){
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            String expectedCountryName="India";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            driver.findElement(By.id("autocomplete")).sendKeys("ind");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.ui-menu-item")));
            List<WebElement> dynamic_elements = driver.findElements(By.cssSelector("li.ui-menu-item"));
            int size_of_elements = dynamic_elements.size();
            for(int i=0;i<size_of_elements;i++){
                if(dynamic_elements.get(i).getText().equals(expectedCountryName)){
                    dynamic_elements.get(i).click();
                    break;
                }
            }

            String selected_country_name = driver.findElement(By.id("autocomplete")).getText();
            if (selected_country_name.equals(expectedCountryName)){
                Assert.assertTrue(true);
            }

            driver.close();

        }
    }

