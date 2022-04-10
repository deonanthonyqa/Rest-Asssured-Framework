package RestAssuredFramework.apiFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponseOptions.*;



import RestAssuredFramework.apiFramework.Helpers.UserHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UsersTest {

	UserHelper userHelp = new UserHelper();
	
@BeforeClass
public void init()
{
	UserHelper userHelp = new UserHelper();
}

@Test
void createUser_001() {
	Response response = userHelp.createUser();
	
	assertTrue(response.getStatusCode()==201);
	
}

@Test
void getUser_002() {
	Response response = userHelp.getUsers();
	assertTrue(response.getStatusCode()==200);

	
	List<String> names = response.path("name");
	
	assertTrue(names.contains("Aatreya Kaul"));
}



}
