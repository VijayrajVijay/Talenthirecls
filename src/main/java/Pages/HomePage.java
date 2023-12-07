package Pages;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import Support.Xpath;
import Support.ReadProperty;
import Support.SeleniumMethods;
import java.io.*;  

public class HomePage extends SeleniumMethods{
	
	Xpath xp;


	public HomePage() throws IOException{
	 xp=new Xpath();
	}
	

	
	
	public void downloadResume(String ID) throws InterruptedException {
		xp.Xpath_Link_ID=xp.Xpath_Link_ID.replace("PARAMETER",ID );

		clickElement(xp.Xpath_Link_ID);
		Thread.sleep(6000);
		File downloadFolder = new File(getDownloadPath());
		File[] listOfFiles = downloadFolder.listFiles();

		// Loop through the files in the download directory
		for (File file : listOfFiles) {
			System.out.println(file.getName());
		    if (file.getName().length()>9) {
		        String newFileName = ID+".docx";  // Set your desired new file name here
		        File newFile = new File(getDownloadPath() + "\\" + newFileName);
		        
		        // Rename the file
	        if (file.renameTo(newFile)) {				
		            System.out.println("File renamed successfully.");
		        } else {
		            System.out.println("File renaming failed.");
		        }
		    }
		}
	}
	
	public void downloadAllResume() throws InterruptedException {
		
		selectValue(xp.Xpath_SelectRows,"10");
		Thread.sleep(1000);
      
		int counter=1;
		while(!getTextValue(xp.Xpath_Next).contains("disabled")) {
			if(counter!=1) {
				clickElement(xp.Xpath_Next);
			}
			Thread.sleep(2000);

		
		
		List<WebElement> elementsId=getListOfWebElements(xp.Xpath_Link_ID_count);
		List<WebElement> elements=getListOfWebElements(xp.Xpath_Link_ID_resume);

		
		for(int i=0;i<elementsId.size();i++) {
			String ID=elementsId.get(i).getText(); // getting ID 
			Thread.sleep(1000);
			clickElement(xp.Xpath_textBox);
			Thread.sleep(2000);
			elements.get(i).click();// resume clicking
			Thread.sleep(4000);
			File downloadFolder = new File(getDownloadPath());
			File[] listOfFiles = downloadFolder.listFiles();

			// Loop through the files in the download directory
			for (File file : listOfFiles) {
				System.out.println(file.getName());
			    if (file.getName().length()>9) {
			        String newFileName = ID+".docx";  // Set your desired new file name here
			        File newFile = new File(getDownloadPath() + "\\" + newFileName);
			        
			        // Rename the file
		        if (file.renameTo(newFile)) {				
			            System.out.println("File renamed successfully.");
			        } else {
			            System.out.println("File renaming failed.");
			        }
			    }
			}
		}
		counter++;
		}
		
	
	}










	public void clickTalentBench() {
		clickElement(xp.Xpath_Link_TalentBench);
		
	}
	

}
