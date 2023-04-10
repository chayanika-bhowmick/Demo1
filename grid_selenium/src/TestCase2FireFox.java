

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class TestCase2FireFox {

	@Test
	public void TestCase2firefox() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("MicrosoftEdge");
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.218:4444"),caps);
		driver.get("http://rahulshettyacademy.com");
		driver.getTitle();
	}
}
