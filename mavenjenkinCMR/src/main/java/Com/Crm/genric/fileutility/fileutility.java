
package Com.Crm.genric.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class fileutility {
	public String getdatafromproperties(String key) throws IOException
	{
	   FileInputStream fis = new FileInputStream("./configAppdata/cmr.properties");
	  Properties p = new Properties();
	  p.load(fis);
	  String data = p.getProperty(key);
	  return data;
	 
	}

}
