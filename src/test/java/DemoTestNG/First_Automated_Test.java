package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First_Automated_Test {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lambdatest.com/selenium-playground");
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	@BeforeMethod
	public void goHome() {
		driver.get("https://www.lambdatest.com/selenium-playground");
	}
	
	@Test (priority = 1)
	public void testTableSortAndSearch() {
		driver.findElement(By.linkText("Table Sort & Search")).click();
		driver.findElement(
			By.xpath("//div[@id='example_filter']//input[@type='search']"))
			.sendKeys("A. Satou");
	}
	@Test (priority = 2)
	public void testBootstrapDatePicker() {
		driver.findElement(By.linkText("Bootstrap Date Picker")).click();
		driver.findElement(By.id("birthday")).sendKeys("06/07/2008");
	}
}
