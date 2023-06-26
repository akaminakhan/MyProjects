package demo;

//import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
//import net.bytebuddy.asm.Advice.Enter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Linkedin {
    ChromeDriver driver;

    public Linkedin() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testcase01() {
        System.out.println("Start Test case: testCase01");

        driver.get("https://www.linkedin.com/checkpoint/lg/sign-in-another-account");

        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.sendKeys("akaminakhan21@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Adnan@456");

        WebElement signInSubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInSubmitButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement startPostField = driver.findElement(By.xpath("//button[@id='ember25']"));
        startPostField.click();

    }
}
