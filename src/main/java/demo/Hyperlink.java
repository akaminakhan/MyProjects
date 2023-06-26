package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.BrowserType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.Select;


public class Hyperlink {
    ChromeDriver driver;
    public Hyperlink()
    {
        System.out.println("Constructor: TestCases");
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

    
    public  void testcase01(){
        System.out.println("Start Test case: testcase01");
     //   Open URL  "https://in.bookmyshow.com/explore/home/chennai"
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
    //Count hyperlinks on the page using XPath Using Locator "XPath" "//a".size()
        List<WebElement> links = driver.findElements(By.tagName("a"));
    //Print the count of hyperlinks 
        System.out.println(links.size());
        
        
        System.out.println("end Test case: testcase01");
    }

}
