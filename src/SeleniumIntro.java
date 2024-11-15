import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver",
//				"/home/devesh-ssd/Downloads/chromedriver-linux64/chromedriver");
		System.setProperty("webdriver.gecko.driver","/home/devesh-ssd/Downloads/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.instagram.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
