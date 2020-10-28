package APITest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class APITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(System.in);
		//get the response as string
		String jsonstring=getData();
		//Create the JSON object types as per the JSON Editor Online - pass in the response
		//Root level - object (type=object)
		JSONObject jsonResponse = new JSONObject(jsonstring);
		//First Level - Networks (type=array)
		JSONArray networks_array=new JSONArray(jsonResponse.getJSONArray("networks").toString());
		
		//Iterate through the JSONArray and pull the required data
		Iterator<Object> objectIterator =  networks_array.iterator();
		while(objectIterator.hasNext()) {
			JSONObject object = (JSONObject) objectIterator.next();
			
			float latitude = (float) 0.000000;
			float longitude = (float) 0.000000;
			
			JSONObject location = object.getJSONObject("location");
			String y = location.getString("country");
			String p = location.getString("city");
			latitude = location.optFloat("latitude");
			longitude = location.optFloat("longitude");
			
			//print the result to console
			System.out.println(y+" - "+p+" - LAT: "+latitude+", LONG: "+longitude);
		}	
	}
	
	public static String getData() {
		String response = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("http://api.citybik.es/v2/networks/").openConnection();
			connection.setRequestMethod("GET");
			int responsecode = connection.getResponseCode();
			if(responsecode==200) {
				response="";
				Scanner scanner = new Scanner(connection.getInputStream());
				while(scanner.hasNextLine()){
					response += scanner.nextLine();
					response += "\n";
				}
				scanner.close();
				//Check if there is data in response (code=200)
				//System.out.println(responsecode);
				return response;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response; 
	}

}
