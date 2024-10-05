package DemoTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting2 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test (threadPoolSize = 3, invocationCount = 4)
	public void test3_BootstrapAlerts() {
		driver.get("https://www.lambdatest.com/selenium-playground/bootstrap-alert-messages-demo");
		System.out.println(Thread.currentThread().threadId()+
				": Bootstrap Alert Message Page");
	}
	@Test
	public void test4_DragAndDropRangeSlider() {
		driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
		System.out.println(Thread.currentThread().threadId()+
				": Drag And Drop Ranger Slider Page");
	}
}
