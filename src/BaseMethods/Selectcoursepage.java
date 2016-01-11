package BaseMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Selectcoursepage {

	
private AppiumDriver d;
	
	
	@AndroidFindBy(id="com.byjus.thelearningapp:id/course_continue_button_view")
	public WebElement Continuebutton;
	
	
	@AndroidFindBy(id="com.byjus.thelearningapp:id/snackbar_text")
	public WebElement ContinueErrormess;
	
	

	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@index='1']")
	public WebElement Selectcourse7th;
	
	


	
	
	
	public Selectcoursepage(AppiumDriver<WebElement> d) {
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
		
	}
	
	
	public void clickcontinuebutton() throws Exception
	{
		Continuebutton.click();
		
	 }	

	public void verifycontinue(String test) throws Exception
	{
		if (test != null && !test.isEmpty()) 
		{
		String s=ContinueErrormess.getText();
		Assert.assertEquals(s, test);
	}
	}
	
	public void click7th() throws Exception
	{
		Selectcourse7th.click();
		
	}
}
