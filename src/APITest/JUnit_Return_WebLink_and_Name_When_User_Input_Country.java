package APITest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

class JUnit_Return_WebLink_and_Name_When_User_Input_Country {

	@Test
	void test() {
		//Collect Input from User using bufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please Enter Country Code:");
		//read the input
		try {
			String countrycode = reader.readLine();
			
			//get the complete response
			String response = APITest.getData();
			//Create the JSON object types as per the JSON Editor Online - pass in teh response
			//Root level - object (type=object)
			JSONObject jsonresponse = new JSONObject(response);
			//First Level - Networks (type=array)
			JSONArray networks_array=new JSONArray(jsonresponse.getJSONArray("networks").toString());
			
			System.out.println(networks_array.isEmpty());
			//Iterate through the JSONArray and pull the required data
			Iterator<Object> objectIterator =  networks_array.iterator();
			
			while(objectIterator.hasNext()) {
				JSONObject object = (JSONObject) objectIterator.next();
				
				String a = object.getString("name");
				String href = object.getString("href");
				
				float latitude = (float) 0.000000;
				float longitude = (float) 0.000000;
				
				JSONObject location = object.getJSONObject("location");
				String y = location.getString("country");
				String p = location.getString("city");
				latitude = location.optFloat("latitude");
				longitude = location.optFloat("longitude");
				
				if(y.equals(countrycode)) {
					System.out.println(a+" - "+href);
					System.out.println(y+" - "+p+" - LAT: "+latitude+", LONG: "+longitude+"\n");
				}

			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
