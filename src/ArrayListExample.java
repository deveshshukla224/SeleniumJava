import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.concurrent.TimeUnit;

public class ArrayListExample {


    public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubWebDriver driver = new ChromeDriver()
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		// timeout for 2 seconds
		//create an array of item which needs to added in cart instead of hard coding something in loops
		// we just need to update value in one place and everything is good
		// initially we have given array instead of arrayList because array take less space in memory
        String [] expectedViggies = {"Beetroot","Brinjal","Tomato"};
        addItems(driver,expectedViggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacadem");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//promo_code_input.sendKeys("rahulshettyacademy");

		//WebElement applied_code_value = driver.findElement(By.cssSelector("span.promoInfo"));
		WebElement code_applied_element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("span.promoInfo"))));
		String message = code_applied_element.getText();
		System.out.println("Applied code value is "+message);

		driver.quit();


	}

	public static void addItems(WebDriver driver, String [] expectedViggies) throws InterruptedException {
		int item_added_in_cart = 0;
		int countExpectedVeggies = expectedViggies.length;
		//find name of all products
		List<WebElement> product_names = driver.findElements(By.cssSelector("h4.product-name"));
		//loop over received list of items of product name
		//size() is used get length of arrayList
		for(int i=0;i<product_names.size();i++){
			//using get() to select an specific element(index) and then grab text of that one
			String product_name = product_names.get(i).getText();
			//System.out.println("Product Name is "+product_name);
			// since name of product is also contains quantity so we need to split string and find name only
			// split return array
			String [] formattedProductName = product_name.split(" - ");
			//System.out.println("FormattedName is"+formattedProductName[0]);
			// name of product is the first thing after splitting it
			String actual_product_name = formattedProductName[0].trim();
			List<String> expectedViggiesList = Arrays.asList(expectedViggies);
			//System.out.println("Array List"+ expectedViggiesList);

			//initially number of items in cart
			if (expectedViggiesList.contains(actual_product_name)){
				// instead of reallying on text so should pass some generic xpath
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				item_added_in_cart++;
				//increase item in cart after every click and once item in cart matches with count of expected veggies exit the for loop using break
				Thread.sleep(2000);
				if (countExpectedVeggies == item_added_in_cart) break;
			}
		}
	}

}
