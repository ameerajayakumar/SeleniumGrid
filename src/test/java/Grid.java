import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid {

	@Parameters("browser")
	@Test
	public void sample(String b) throws MalformedURLException {

		// DesiredCapabilities cap = DesiredCapabilities.firefox();
		DesiredCapabilities cap = null;
		if (b.equals("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		} else if (b.equals("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);

		} else if (b.equals("safari")){
			cap = DesiredCapabilities.safari();
			cap.setBrowserName("safari");
			cap.setPlatform(Platform.ANY);

		}
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("hellohowareyou@gmail.com");
		driver.quit();
	}

}
