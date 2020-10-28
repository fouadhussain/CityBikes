Code Challenge - Module 2 - City Bikes (API Test)
-----------------------------------------------------------------------------------
Author: Fouad Hussain

Project Notes: 
- JUnit 5; TestNG; JavaSE_14
- Use of JSON Objects to handle Response

- Run the main java program in APITest package - APITest.java
- Run testng.xml --> Suite of 5 key tests to validate API works as expected
- Run dynamic console tests in APITest package --> 2 JUnit tests called "JUnit_Return..."
------------------------------------------------------------------------------------
JUnit Tests
------------------------------------------------------------------------------------

----------------------------------------------------
1. JUnit_Verify_Frankfurt_in_Germany.java
----------------------------------------------------
Test Description: 

- As a user I want to verify that the city Frankfurt is in Germany and return the corresponded latitude and longitude

Test Input Data:

- None

Expected result:

- The line is returned shows that Frankfurt is part of Germany (DE) with the corresponding latitude and longitude data


----------------------------------------------------
2. JUnit_List_CityBike_Companies_In_Russia.java
----------------------------------------------------
Test Description: 

- As a user I want to list all the City Bike entities in Russia

Test Input Data:

- None

Expected result:

- List of entities in Russia associated with City Bikes and web link


----------------------------------------------------
3. JUnit_List_CityBike_Locations_In_China_With_WebLink
----------------------------------------------------
Test Description: 

- As a user I want to list all the City Bike locations in China with their web link

Test Input Data:

- None

Expected result:

- No Results returned

----------------------------------------------------
4. JUnit_List_CityBike_Locations_In_UK_With_Coordinates
----------------------------------------------------
Test Description: 

- As a user I want to list all the City Bike locations in UK with their coordinates

Test Input Data:

- None

Expected result:

- UK locations returned with corresponding Latitude and Longitude 


----------------------------------------------------
5. JUnit_List_CityBike_Locations_USA_With_WebLink
----------------------------------------------------
Test Description: 

- As a user I want to list all the City Bike locations in USA with their coordinates & WebLink

Test Input Data:

- None

Expected result:

- USA locations returned with corresponding Latitude, Longitude and Web Link 

----------------------------------------------------
6. Junit_Return_List_Of_CityBikes_User_Enter_CountryCode
----------------------------------------------------
Test Description: 

- As a user I want to dynamically enter the country code and get a list of city bike locations for that country

Test Input Data:

- GB

Expected result:

- GB locations returned with corresponding Latitude, Longitude 


----------------------------------------------------
7. JUnit_Return_WebLink_and_Name_When_User_Input_Country
----------------------------------------------------
Test Description: 

- As a user I want to dynamically enter the country code and get a list of city bike locations for that country with the associated company information

Test Input Data:

- US

Expected result:

- USA locations returned with corresponding Latitude, Longitude and company information
- Data is formatted and grouped correctly with a line space between each location group
