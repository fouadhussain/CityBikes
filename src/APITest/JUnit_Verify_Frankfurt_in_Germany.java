package APITest;
import org.testng.annotations.Test;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.junit.jupiter.api.Test;

class JUnit_Verify_Frankfurt_in_Germany {

	@Test
	void test() {
		//Given - Frankfurt
		//When 
		//Then - Return latitude and longitude
		//By returning the latitude & longitude we can assert whether Frankfurt
		//is in Germany
		//Collect Input from User using bufferReader
		
		String city="Frankfurt";
		
		String response = APITest.getData();
		//Create the JSON object types as per the JSON Editor Online - pass in teh response
		//Root level - object (type=object)
		JSONObject jsonresponse = new JSONObject(response);
		//First Level - Networks (type=array)
		JSONArray networks_array=new JSONArray(jsonresponse.getJSONArray("networks").toString());
		
		//System.out.println(networks_array.isEmpty());
		Iterator<Object> objectIterator =  networks_array.iterator();
		
		while(objectIterator.hasNext()) {
			JSONObject object = (JSONObject) objectIterator.next();
			//String x = object.getString("id");
			//System.out.println(x);
			float latitude = (float) 0.000000;
			float longitude = (float) 0.000000;
			
			JSONObject location = object.getJSONObject("location");
			String y = location.getString("country");
			String p = location.getString("city");
			latitude = location.optFloat("latitude");
			longitude = location.optFloat("longitude");
			
			if(p.equals(city)) {
				System.out.println(y+" - "+p+" - LAT: "+latitude+", LONG: "+longitude);
			}
		}
	}

}
