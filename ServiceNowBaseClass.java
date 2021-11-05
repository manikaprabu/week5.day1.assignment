package week5.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBaseClass {
	public ChromeDriver driver;
@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev58659.service-now.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame(driver.findElement(By.id("gsft_main")));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
@AfterMethod
	public void postCondition() {
		driver.close();

	}

}
