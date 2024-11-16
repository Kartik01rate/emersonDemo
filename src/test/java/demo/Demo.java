package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	private WebDriver driver;

	@BeforeMethod
	public void launch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KARTIK'S\\Downloads\\inetbankingV1-master\\inetbankingV1-master\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@Test
	public void openPage() {
		System.out.println("Hello - page is landed");
		String title = driver.getTitle();
		System.out.println("Title of the landed page is - " + title);
	}

	@AfterClass
	public void exit() {
		if (driver != null) {
			driver.quit();
		}
	}
}
