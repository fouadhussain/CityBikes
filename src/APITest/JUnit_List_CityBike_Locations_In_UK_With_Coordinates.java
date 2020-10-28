package APITest;

import org.testng.annotations.Test;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;


class JUnit_List_CityBike_Locations_In_UK_With_Coordinates {

	@Test
	void test() {
			String countrycode ="GB"; //UK Country Code
			//get the complete response
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
				
				float latitude = (float) 0.000000;
				float longitude = (float) 0.000000;
				
				JSONObject location = object.getJSONObject("location");
				String y = location.getString("country");
				String p = location.getString("city");
				latitude = location.optFloat("latitude");
				longitude = location.optFloat("longitude");
				
				if(y.equals(countrycode)) 
				{
					System.out.println(y+" - "+p+" - LAT: "+latitude+", LONG: "+longitude);
				}
			
			}
		
	}

}
