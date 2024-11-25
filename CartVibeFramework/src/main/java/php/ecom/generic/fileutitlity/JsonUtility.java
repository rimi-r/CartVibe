package php.ecom.generic.fileutitlity;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getTheDataFromJsonFile(String data) throws IOException, ParseException {
		
	
	FileReader fr=new FileReader("./src/test/resources/CartVibeConfigData.json");
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(fr);
	JSONObject jObj=(JSONObject) obj;
	String configData=(String) jObj.get(data);
	return configData;

}
}
//C:\\Users\\rstar\\OneDrive\\Desktop\\CartVibeConfigData.json