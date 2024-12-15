package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class1 {
	public static void main(String args[]) throws IOException, InterruptedException {

		// Load configuration properties from a file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./Configuration\\config.properties");
		prop.load(fis);
		String bName = prop.getProperty("chromepath");

		// Set the path for the ChromeDriver reading from config file
		System.setProperty("webdriver.chrome.driver", bName);

		// Initialize WebDriver
		ChromeOptions co = new ChromeOptions();
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");

		// Set implicit wait globally (applies to all element lookups)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Global implicit wait for 10 seconds
		System.out.println("Page launched");

		// Initialize JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		
		
		
		//asdf
		// Explicit wait for the menu to be clickable before clicking
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Explicit wait with Duration
		WebElement menu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/deals?ref_=nav_cs_gb']")));
		js.executeScript("arguments[0].click();", menu); // Using JavaScriptExecutor for the click
		System.out.println("Menu clicked");

		// Explicit wait for the deal link to be clickable before clicking
		WebElement deal = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='GridRow-module__container_q6XsDi4clqdE6jhYFSBW']/div[1]//a")));
		deal.click();
		System.out.println("Deal clicked");

		// Explicit wait for the 'Add to Cart' button to be clickable before clicking
		js.executeScript("window.scrollBy(0, 200);");
		WebElement addCartBtn = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']//input"));
		js.executeScript("arguments[0].click();", addCartBtn); // Using JavaScriptExecutor for the click
		System.out.println("Add to Cart clicked");

		// Close the browser
		System.out.println("Closing the browser");
		driver.quit();
	}
}
