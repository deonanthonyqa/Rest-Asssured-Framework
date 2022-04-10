package RestAssuredFramework.apiFramework.Helpers;


import RestAssuredFramework.apiFramework.Utils.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


import RestAssuredFramework.apiFramework.Constants.UserEndpoints;
import RestAssuredFramework.apiFramework.Models.Users;

public class UserHelper {
	
	Users user = new Users();
	ConfigManager conf = new ConfigManager();
	
	public UserHelper() {
		RestAssured.baseURI=conf.getPropertiesValue("apiUrl");
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public Response createUser() {
		user.setName("DeonA");
		user.setEmail("deontesting@qa.com");
		user.setGender("male");
		user.setStatus("active");
		
		Response response = given()
				.header("Content-Type","application/json")
				.header("Authorization","Bearer "+conf.getPropertiesValue("bearerToken"))
				.body(user).log().all()
				.when()
				.post(UserEndpoints.CREATE_USER)
				.then()
				.extract().response();
	return  response;
				
	}
	
	public Response getUsers() {
		Response response = given()
				.header("Content-Type","application/json")
				.when()
				.get(UserEndpoints.GET_ALL_USERS)
				.then()
				.extract().response();
		return  response;
	}

}
