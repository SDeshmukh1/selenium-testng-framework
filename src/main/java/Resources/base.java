package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		String browserName = readProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String readProperty(String value) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties");
		System.out.println(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		return prop.getProperty(value);
	}
	
	public void takeScreenshot(String result) throws IOException
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String timeStamp = new String("\\Screenshots" + "\\" +result +timestamp + "screenshot.png");
		String tsNew = timeStamp.replaceAll(":", "-");
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")  + tsNew));
	}
}
