package BaseMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Homepagepattern {
	
private AppiumDriver d;
	
	
	@AndroidFindBy(className="android.widget.Button")
	public WebElement Getstarted;
	
	
	@AndroidFindBy(id="com.byjus.thelearningapp:id/tvTitle")
	public WebElement Selectcourse;
	
	


	
	
	
	public Homepagepattern(AppiumDriver<WebElement> d) {
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
		
	}
	
	
	public void clickGetstarted() throws Exception
	{
		Getstarted.click();
		
	 }	

	public void verify(String test) throws Exception
	{
		if (test != null && !test.isEmpty()) 
		{
		String s=Selectcourse.getText();
		Assert.assertEquals(s, test);
	}

	}
		
	
}
