package Tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class FileDownload {
	
	HomePage hp;
	LoginPage lp;
	@BeforeMethod
	public void stepUp() throws IOException {
		hp =new HomePage();
		lp=new LoginPage();
	}
	
	@Test
	public void execute() throws IOException, InterruptedException {
		lp.LaunchBrowser();
		lp.loginToApplication();
		hp.clickTalentBench();
		hp.downloadAllResume();
		//hp.downloadResume("1605");
		
	

}
}