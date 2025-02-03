import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicAssersation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "/home/devesh-ssd/Downloads/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		// maximize window
		driver.manage().window().maximize();
		// timeout for 5 seconds
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		boolean is_friend_family_selected = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"))
				.isSelected();

		// First Basic Assersation is Assert.assertFalse() - we are expecting the result
		// to be false inside this otherwise it will fail
		// Before selection we are expecting this will not be selected so false will be
		// returned and if false is returned for Assert.assertFalse() then it will pass
		Assert.assertFalse(is_friend_family_selected);
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		is_friend_family_selected = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();

		// Second Basic Assersation is Assert.assertTrue() - we are expecting the result
		// to be true inside this otherwise it will fail
		// After selection we are expecting this will be selected so true will be
		// returned and if true is returned for Assert.assertTrue() then it will pass
		Assert.assertTrue(is_friend_family_selected);

		// Third basic assersation is about comparing result Assert.assertEquals(actual
		// , expected)

		String title_of_page = driver.getTitle();
		Assert.assertEquals(title_of_page,
				"QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");

		driver.close();

	}

}
