import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumIntro {
	public static void main(String[] args) {
		// Set the correct path for GeckoDriver
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver"); // Windows
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver"); // macOS/Linux

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
