package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterizedTest {

	WebDriver driver;
	
	@Parameters({"URL"})
	@BeforeClass
	public void setUp(String url) {// can be any names
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Step1 : Load AUT
		driver.get(url);
	}
	
	@Test
	@Parameters({"Task", "TestResult"})
	public void testFileDownload(String task, String testResult) {
		// Step 2: Click The File Download Link
		driver.findElement(By.linkText("File Download")).click();;
		// Step 3: Enter Data
		driver.findElement(By.id("textbox")).sendKeys(task +
				"Execution:" + testResult);
		// Step 4: Click the Generate File Button
		driver.findElement(By.id("create")).click();
		// Step 5: Click the Download Link
		driver.findElement(By.id("link-to-download")).click();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
