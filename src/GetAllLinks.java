import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Struct;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GetAllLinks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> count_links = driver.findElements(By.tagName("a"));
        System.out.println("Count of links " + count_links.size());

        //Limit the scope to footer only
        WebElement footer_driver = driver.findElement(By.id("gf-BIG"));
        int count_links_footer = footer_driver.findElements(By.tagName("a")).size();
        System.out.println("Count of Links in Footer Section " + count_links_footer);




        //Find the links of first colum
        WebElement first_column = footer_driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int first_colum_links_count = first_column.findElements(By.tagName("a")).size();
        System.out.println("Count of Links of first column in footer " + first_colum_links_count);



        //Click all links of First Column in new tab using keys.chrod

        for (int i=1; i<first_colum_links_count; i++) {
            String open_link_new_tab = Keys.chord(Keys.CONTROL,Keys.ENTER);
                    first_column.findElements(By.tagName("a")).get(i).sendKeys(open_link_new_tab);
        }


        //switch to each window and get title of page
        //Method 1
        Set<String> windows = driver.getWindowHandles();
//        for(String window: windows){
//            driver.switchTo().window(window);
//            String title = driver.getTitle();
//            System.out.println("Title of page is "+title);
//        }

        //Method 2
        Iterator<String> it=windows.iterator();
        //check if it has next window or index
        while(it.hasNext()){
            //move to next window using it.next()
            driver.switchTo().window(it.next());
            String title_of_page = driver.getTitle();
            System.out.println("Title of pages "+title_of_page);
        }
    }
}
