package Support;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ReadProperty {
 
	public static Properties props;
	FileReader reader;
	  public ReadProperty() throws IOException{
		   reader=new FileReader(System.getProperty("user.dir")+"\\Configuration.properties");
	         props=new Properties();
		        props.load(reader);	  

	  }
	 
	  
	  public String getProperty(String propertyname) throws IOException {
	       return props.getProperty(propertyname);
	  }
	
	
	
	
	
}
