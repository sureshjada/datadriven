package BaseMethods;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Registationpage {
	
private AppiumDriver d;
	
	
	@AndroidFindBy(id="com.byjus.thelearningapp:id/register_promotion")
	public WebElement registermess;
	
	


	
	public Registationpage(AppiumDriver<WebElement> d) {
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
		
	}
	
	
	public void VerifyRegisermess(String test) throws Exception
	{
		String s=registermess.getText();
		Assert.assertEquals(s, test);
		
	 }	

}
