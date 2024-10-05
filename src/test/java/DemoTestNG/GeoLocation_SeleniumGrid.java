package DemoTestNG;

import java.net.MalformedURLException;
import java.net.URI;
//import java.net.URL;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GeoLocation_SeleniumGrid {
	public WebDriver driver;
	private String username = "Rex.Jones";
	private String accessKey = "";
	private String hub = "@hub.lambdatest.com/wd/hub";
	DesiredCapabilities caps = new DesiredCapabilities();
	
	@BeforeClass
	public void setUp() {
		caps.setCapability("build", "3.1");
		caps.setCapability("name", "Test GeoLocation");
		caps.setCapability("geoLocation", "IN");
		caps.setCapability("browserName", "chrome");
		caps.setCapability("version", "103.0");
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("network", true);
		caps.setCapability("console", true);
		caps.setCapability("visual", true);
		try {
			driver = new RemoteWebDriver(new URI("https://" +
					username + ":" +accessKey + hub).toURL(), caps);
		}
		catch (MalformedURLException exc) {
			exc.printStackTrace();
		}
		catch (URISyntaxException ex) {
			ex.printStackTrace();
		}
		
		driver.get("https://where-am-i.org/");
	}
	
	@Test
	public void testGeoLocation() {
		WebElement address = driver.findElement(By.id("address"));
		System.out.println("Address: " + address.getText());
	}
	
}
