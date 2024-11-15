import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//first identify element for select tag
		WebElement selectTagelement = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// pass that element as an argument while creating object of select class
		Select dropdown = new Select(selectTagelement);
		
		//select element by index value
	    dropdown.selectByIndex(2);
	    Thread.sleep(2000);
	    //if only one element is selected then get the selected element using getFirstElementSelected
		String select_item_text=dropdown.getFirstSelectedOption().getText();
	    System.out.println("1 "+select_item_text);
	    
	    //select element using it's value , find it by value attribute in tag
	    dropdown.selectByValue("USD");
	    Thread.sleep(2000);
	    String select_item_text1=dropdown.getFirstSelectedOption().getText();
	    System.out.println("2 "+select_item_text1);
	    
	    //select element using visible text
	    dropdown.selectByVisibleText("INR");
	    Thread.sleep(2000);
	    String select_item_text2=dropdown.getFirstSelectedOption().getText();
	    System.out.println("3 "+select_item_text2); 
	    driver.close();
	}

}
