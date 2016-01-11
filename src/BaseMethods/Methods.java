package BaseMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Methods {
	
	public static Properties OR=null;
	public static boolean IsInitilised=false;
	
	private AppiumDriver d;

	
	
	
	public Methods(WebDriver d) {
		this.d = (AppiumDriver) d;
	}
	
	


public void initilized1() throws IOException  /** Loding Properties file declaration */
{
		
	    if(!IsInitilised)
	     {
			OR = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\Config\\OR.properties");
			OR.load(ip);
			IsInitilised=true;
		
	  }
}


public void clickGetstarted() throws Exception
{
	AndroidElement e= (AndroidElement) d.findElement(By.className(OR.getProperty("Getstarted_className")));
	Thread.sleep(6000);
	e.click();
	
 }	

public void clickcontune() throws Exception
{
	
	AndroidElement e=(AndroidElement) d.findElement(By.id(OR.getProperty("Continuebutton_id")));
	e.click();
}

public void Verifytestselectcourse(String test) throws Exception
{

	String e=d.findElement(By.id("com.byjus.thelearningapp:id/tvTitle")).getText();

	Assert.assertEquals(e, test);

}
	
}

