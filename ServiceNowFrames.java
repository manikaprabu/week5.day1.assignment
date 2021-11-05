package week5.day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames extends ServiceNowBaseClass{
@Test
	public void serviceNowTestcase() throws InterruptedException, IOException {
	
		
		driver.findElement(By.id("filter")).sendKeys("incident");
		driver.findElement(By.xpath("//span[text()='Incident']/following::div[text()='All']")).click();	
		driver.switchTo().frame(driver.findElement(By.id("gsft_main")));
		driver.findElement(By.xpath("//button[text()='New']")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sys_display.incident.caller_id"))));
		driver.findElement(By.id("sys_display.incident.caller_id")).sendKeys("System Administrator");
		Thread.sleep(2000);
		driver.findElement(By.id("incident.short_description")).sendKeys("Test description");
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");	
		System.out.println("Incident Number is" + incidentNumber);
		driver.findElement(By.xpath("//button[@id ='sysverb_insert']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class= 'input-group-addon input-group-select']/following-sibling::input")).sendKeys(incidentNumber,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//table/tbody/tr/td/a)[2]")).click();
		File src = driver.getScreenshotAs(OutputType.FILE);		
		File dst= new File("./snap/servicenow.png");		
		FileUtils.copyFile(src, dst);

	}

}
