import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

public class AssignmentOne {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        // Disable password saving prompts
//        options.addArguments("--disable-save-password-bubble");
//        options.addArguments("--disable-autofill-keyboard-accessory-view");
//        options.addArguments("--disable-features=AutofillServerCommunication");
//        options.addArguments("--disable-features=PasswordManagerOnboarding,OptInAndSaveUi");
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        // maximize window
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebElement username_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        WebElement password_field = driver.findElement(By.id("password"));
        WebElement user_radio_option = driver.findElement(By.cssSelector("input[value='user']"));
        //WebElement opt_yes_for_user = driver.findElement(By.id("okayBtn"));
        WebElement select_option = driver.findElement(By.tagName("select"));
        WebElement t_c_checkbox = driver.findElement(By.cssSelector("input#terms"));
        WebElement signInButton = driver.findElement(By.cssSelector("input[name='signin']"));

        username_field.sendKeys("rahulshettyacademy");
        password_field.sendKeys("learning");
        user_radio_option.click();
        WebElement ok_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        ok_btn.click();
        // Create Select object
        Select select = new Select(select_option);
        select.selectByValue("stud");
        t_c_checkbox.click();
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='ProtoCommerce Home']")));
        List<WebElement> items = driver.findElements(By.className("card-footer"));
        int size_of_items = items.size();
        int item_added = 0;
        for (WebElement item : items) {
            if (item_added != size_of_items) {
                item.findElement(By.tagName("button")).click();
                item_added++;
            } else break;
        }
        String checkout_btn_text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Checkout')]"))).getText();
        System.out.println("Checkout button text is "+checkout_btn_text);

        WebElement checkout_btn = driver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
        checkout_btn.click();
        driver.close();
    }
}
