import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid2 {

	@Test(dataProvider = "getData")
	public void sample(String username, String pass, String b) throws MalformedURLException {

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
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.quit();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		Object[][] data = new Object[3][3];
		data[0][0] = "user1@gmail.com";
		data[0][1] = "userpass";
		data[0][2] = "firefox";
		data[1][0] = "user2@gmail.com";
		data[1][1] = "userpass";
		data[1][2] = "chrome";
		data[2][0] = "user3@gmail.com";
		data[2][1] = "userpass";
		data[2][2] = "safari";
		return data;
	}

}
