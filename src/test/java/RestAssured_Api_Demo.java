import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssured_Api_Demo extends BaseClass{

    @Test
    public void postMethodToCreateUser(){
        ExtentTest test = extent.createTest("Test Case to create new user");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(createNewUser).when()
                .post("https://reqres.in/api/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Correct status code returned");

        test.pass("New user created successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");
    }

    @Test
    public void getMethodToGetUser(){
        ExtentTest test = extent.createTest("Test Case to get User");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given().get("https://reqres.in/api/users/2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Correct status code returned");

        test.pass("User fetched successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");
    }

    @Test
    public void putMethodToUpdateUser(){
        ExtentTest test = extent.createTest("Test Case to update user data");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(updateUser).when()
                .put("https://reqres.in/api/users/2");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Correct status code returned");

        test.pass("User data updated successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");
    }

    @Test
    public void deleteMethodToDeleteUser(){
        ExtentTest test = extent.createTest("Test Case to delete user");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given().delete("https://reqres.in/api/users/2");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,204,"Correct status code returned");

        test.pass("User deleted successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");

    }

    @Test
    public void postMethodToRegister(){
        ExtentTest test = extent.createTest("Test Case to register new user");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(NewUser).when()
                .post("https://reqres.in/api/register");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Correct status code returned");

        test.pass("New user registered successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");

    }

    @Test
    public void postMethodToLogin(){
        ExtentTest test = extent.createTest("Test Case to login user");
        test.log(Status.INFO, "Starting test case");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(NewUser).when()
                .post("https://reqres.in/api/login");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Correct status code returned");
        test.pass("User loged in successfully.");
        test.pass("Correct status code returned.");
        test.info("Test completed");

    }
}
