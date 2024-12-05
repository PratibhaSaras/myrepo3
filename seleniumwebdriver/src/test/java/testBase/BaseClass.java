package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;	
	public Properties p;
	
	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException 
	{
		//loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger=(Logger) LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default: System.out.println("Invalid browser name");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		;
		
	}
	
	
    @AfterClass(groups= {"Regression","Sanity","Master"})
	public void tearDown() {
		driver.quit();
	}
    
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
