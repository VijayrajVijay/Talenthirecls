package Pages;


import java.io.IOException;
import Support.Xpath;
import Support.ReadProperty;
import Support.SeleniumMethods;

public class LoginPage extends SeleniumMethods{
	
	Xpath xp;
	ReadProperty rp;

	public LoginPage() throws IOException{
	 xp=new Xpath();
	 rp=new ReadProperty();
	}
	

	
	public void loginToApplication() throws IOException {
		sendKeys(xp.Xpath_Input_Username, rp.getProperty("Username"));
		sendKeys(xp.Xpath_Input_Password, rp.getProperty("Password"));
		clickElement(xp.Xpath_Btn_Signin);
	}

	public void LaunchBrowser() throws IOException {
		launchUrl(rp.getProperty("URL"));
		
	}
	
	

}
