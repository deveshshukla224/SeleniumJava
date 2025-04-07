import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class AssignmentFour {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");


        List<WebElement> rows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
        int num_rows = rows.size();
        System.out.println("Number of Rows "+num_rows);

        int count_of_col = driver.findElements(By.cssSelector("table[name='courses'] tr th")).size();
        System.out.println("Number of Columns "+count_of_col);

        WebElement second_rows = driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(3)"));

        int data_col=second_rows.findElements(By.tagName("td")).size();

        ArrayList<Object> data_of_cols = new ArrayList<>();

        for(int i=0;i<data_col;i++){
            String data = second_rows.findElements(By.tagName("td")).get(i).getText();
            data_of_cols.add(data);
        }

        for(Object data:data_of_cols){
            System.out.println("Value from Array List is "+data);
        }
    }
}
