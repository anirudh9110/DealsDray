package Dealsdray.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomationTest02_FunctionalTestingCase {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("started test");
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\kotaa\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait for 15 seconds
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/");
		
		driver.findElement(By.xpath("//*[@id=\"mui-1\"]")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//*[@id=\"mui-2\"]")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div/form/div[3]/div/button")).click();
		System.out.println("logged in");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/a/button")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"mui-7\"]")).sendKeys("C:\\Users\\kotaa\\Downloads\\demo-data.xlsx");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/button")).click();
		System.out.println("imported the file");
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("screenshot taken");
		String screenshotPath = "C:\\Users\\kotaa\\Pictures\\Automation Test 02 - Functional Testing Case\\dataimport.png";
		try {
			ImageIO.write(ImageIO.read(screenshot),"PNG",new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed test");
		driver.quit();
	}
}
