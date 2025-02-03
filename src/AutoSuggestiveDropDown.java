
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/home/devesh-ssd/Downloads/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//timeout for 5 seconds
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		// Use Find Elements to find list of items
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		//enhanced way for loop - for ( type variable : list)
        for (WebElement option:options) {
        	if(option.getText().equalsIgnoreCase("india")){
        		option.click();
        		System.out.println("India got selected");
        		System.out.println("Selected value is :"+driver.findElement(By.id("autosuggest")).getText());
        		break;
        	}
        	
        }
        driver.close();
	}

}
