package Dealsdray.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class AutomationTest01_UITesting {
	public static void main(String[] args) {
		System.out.println("started test");
		// Define resolutions
		int[][] resolutions = {{1366, 768}, {1920, 1080},{1536,864}}; // Add more resolutions as needed
        
		//xpaths for top 5 links
		String[] xpath_links= {"//*[@id=\"sitemap\"]/tbody/tr[1]/td[1]/a",
				"//*[@id=\"sitemap\"]/tbody/tr[2]/td[1]/a",
				"//*[@id=\"sitemap\"]/tbody/tr[3]/td[1]/a",
				"//*[@id=\"sitemap\"]/tbody/tr[4]/td[1]/a",
		"//*[@id=\"sitemap\"]/tbody/tr[5]/td[1]/a"};

		// Initialize firefox WebDriver
		System.setProperty("webdriver.firefox.marionette", "C:\\Users\\kotaa\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait for 15 seconds
		driver.manage().window().maximize();
		driver.get("https://www.getcalley.com/page-sitemap.xml");
        System.out.println("strated firefox");
		int cnt=0;
		// Loop through links
		for (String link :xpath_links)
		{
			// Navigate to the the links
			driver.findElement(By.xpath(link)).click();
			cnt++;
			// Loop through resolutions
			for (int[] resolution : resolutions) {
				// Set window size
				driver.manage().window().setSize(new Dimension(resolution[0], resolution[1]));


				// Capture screenshot
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String screenshotPath = "C:\\Users\\kotaa\\Pictures\\Automation Test 01 - UI Testing\\firefox\\screenshot_Link"+cnt+" "+resolution[0]+"x"+resolution[1] + ".png";

				// Save screenshot
				try {
					ImageIO.write(ImageIO.read(screenshot),"PNG",new File(screenshotPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			driver.navigate().back();
		}

		// Close the WebDriver
		driver.quit();
        System.out.println("completed firefox");




		// Initialize WebDriver for chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kotaa\\eclipse-workspace\\java web driver\\drivers\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("C:\\Users\\kotaa\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
		WebDriver driver1=new ChromeDriver(options);
		driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait for 15 seconds
		driver1.manage().window().maximize();
		driver1.get("https://www.getcalley.com/page-sitemap.xml");
		System.out.println("started chrome");
		int cnt1=0;
		// Loop through links
		for (String link :xpath_links)
		{
			// Navigate to the the links
			driver1.findElement(By.xpath(link)).click();
			cnt1++;
			// Loop through resolutions
			for (int[] resolution : resolutions) {
				// Set window size
				driver1.manage().window().setSize(new Dimension(resolution[0], resolution[1]));


				// Capture screenshot
				File screenshot = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
				String screenshotPath = "C:\\Users\\kotaa\\Pictures\\Automation Test 01 - UI Testing\\chrome\\screenshot_Link"+cnt1+" "+resolution[0]+"x"+resolution[1] + ".png";

				// Save screenshot
				try {
					ImageIO.write(ImageIO.read(screenshot),"PNG",new File(screenshotPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			driver1.navigate().back();
		}

		// Close the WebDriver
		driver1.quit();
		System.out.println("completed chrome");

		

		// Initialize WebDriver for edge
		System.setProperty("webdriver.edge.driver", "C:\\Users\\kotaa\\eclipse-workspace\\java web driver\\drivers\\msedgedriver.exe");
		WebDriver driver2 = new EdgeDriver();
		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//implicit wait for 15 seconds
		driver2.manage().window().maximize();
		driver2.get("https://www.getcalley.com/page-sitemap.xml");
		System.out.println("started edge");
		int cnt2=0;
		// Loop through links
		for (String link :xpath_links)
		{
			// Navigate to the the links
			driver2.findElement(By.xpath(link)).click();
			cnt2++;
			// Loop through resolutions
			for (int[] resolution : resolutions) {
				// Set window size
				driver2.manage().window().setSize(new Dimension(resolution[0], resolution[1]));


				// Capture screenshot
				File screenshot = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
				String screenshotPath = "C:\\Users\\kotaa\\Pictures\\Automation Test 01 - UI Testing\\edge\\screenshot_Link"+cnt2+" "+resolution[0]+"x"+resolution[1] + ".png";

				// Save screenshot
				try {
					ImageIO.write(ImageIO.read(screenshot),"PNG",new File(screenshotPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			driver2.navigate().back();
		}

		// Close the WebDriver
		driver2.quit();
		System.out.println("completed edge");
		System.out.println("completed test");
	}
}


