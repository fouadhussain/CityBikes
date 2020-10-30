package APITest;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.junit.jupiter.api.Test;

class JUnit_List_CityBike_In_Russia {

	@Test
	void test() {
		String response = APITest.getData();
		//Create the JSON object types as per the JSON Editor Online - pass in teh response
		//Root level - object (type=object)
		JSONObject jsonresponse = new JSONObject(response);
		//First Level - Networks (type=array)
		JSONArray networks_array=new JSONArray(jsonresponse.getJSONArray("networks").toString());
		
		//System.out.println(networks_array.isEmpty()); 
		//Iterate through the JSONArray and pull the required data
		Iterator<Object> objectIterator =  networks_array.iterator();

		while(objectIterator.hasNext()) {
			JSONObject object = (JSONObject) objectIterator.next();
			String a = object.getString("name");
			String href = object.getString("href");
			String cid = object.getString("id");
			
			
			JSONObject location = object.getJSONObject("location");
			String y = location.getString("country");
			String p = location.getString("city");
			
			if(y.equals("RU")) {
				System.out.println("Company ID: "+cid+" - LINK: "+href);
			}
			
			
		
		}
	}

}
