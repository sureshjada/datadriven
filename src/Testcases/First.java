package Testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.portable.CustomValue;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;



import BaseMethods.Homepagepattern;
import BaseMethods.Methods;
import BaseMethods.Registationpage;
import BaseMethods.Selectcoursepage;
import ExcelReading.ExcelDataRead;



public class First {

	
	public AndroidDriver d;
	String TestName2;
	
	/** Launch the url */
	@BeforeMethod(alwaysRun=true )  
	public void launch() throws Exception
	{
	
		DesiredCapabilities capability = DesiredCapabilities.android();
		capability.setCapability("BrowserName", "Android");
		capability.setCapability("deviceName","AndroidEmulator");
		capability.setCapability("platformversion","5.1.1");
		capability.setCapability("platformName","ANDROID");
		capability.setCapability("app","D:/MobileAutomation/app/MarketApp_Server-Time_Production_Release-Build_v2014.apk");
		capability.setCapability("app-package","com.appriss.mobilepatrol");
		capability.setCapability("app-activity",".LaunchScreenActivity");
		capability.setCapability("app-wait-activity",".StartScreenActivity");
		
		
		d=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
		Thread.sleep(25000);	
    }
    
	
	/** Verifying the text select a course */
	@Test(dataProvider = "test1",dataProviderClass = ExcelDataRead.class)
	public void LearnTestcases(String Runmode,String Description,String Testcase,String ExpectedTest,String Continueerrormess,String Registerpagemessage) throws Exception 
	{

	   
		Homepagepattern b=new Homepagepattern(d);
		Selectcoursepage c=new Selectcoursepage(d);
		Registationpage a=new Registationpage(d);
		
		if(Runmode.equals("Y"))
		{
			
			b.clickGetstarted();
			Thread.sleep(3000);
			b.verify(ExpectedTest);
			c.click7th();
			Thread.sleep(2000);
			c.clickcontinuebutton();
			
			//c.verifycontinue(ContinueErrorMessage);
			a.VerifyRegisermess(Registerpagemessage);
		/*a.initilized1();
		a.clickGetstarted();
		Thread.sleep(3000);
		a.Verifytestselectcourse(ExpectedTest);*/
		}
		
		else
		{
			throw new SkipException("[skipTest]=[true];skiping iteration");
		}
}
	  

/** Testcases Failure take a screen shot and close the url */
@AfterMethod(alwaysRun=true )
public void screenshot(ITestResult result) throws IOException  
 {
		 System.out.println(result.getStatus());
		 if((result.getStatus())==2)
		 {
			 
			 File scrFile = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
	         FileUtils.copyFile(scrFile, new File("C:/sureshjada/DatadrivenFramework/Failurescreen/"+ TestName2 + "_"+ new SimpleDateFormat("HHmmss").format(
                        Calendar.getInstance().getTime()).toString() + ".jpeg"));
		 
		 }

d.quit();

}

}
