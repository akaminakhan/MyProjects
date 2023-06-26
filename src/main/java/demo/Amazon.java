package demo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Amazon {
    ChromeDriver driver;
    public Amazon()
    {
        System.out.println("Constructor: Amazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public void testcase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        WebElement searchTextBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchTextBox.sendKeys("Amazon");
        searchTextBox.submit();
        Thread.sleep(3000);

        boolean isAmazonReturned = driver.getPageSource().contains("amazon.in")
                || driver.getPageSource().contains("amazon.com");

        if (isAmazonReturned) {
            System.out.println("Amazon is returned in the search results.");
        } else {
            System.out.println("Amazon is not returned in the search results.");
        }

        driver.quit();
         }

   }
    
