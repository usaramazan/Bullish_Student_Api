package stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import utilities.StudentEditUtil;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class StudentEditTest {

    @Steps
    StudentEditUtil api;

    @Given("Send POST request to add student")
    public void callPostRequest() {
        api.sendPOSTRequest("15200", "Ramazan", "Aksit", "3A", "Turkey");

    }

    @Then("Status code is <201>")
    public void statusCodeToAddStudent(int responseCode) {
        api.validateStatusCodeToBe(responseCode);
    }


    @Given("Send Delete request to delete student")
    public void callDeleteRequest() {
        api.sendDeleteRequestForStudent("22345");
    }

    @Then("Status code is <204>")
    public void statusCodeToDeleteStudent(int responseCode) {
        api.validateStatusCodeToBe(responseCode);

    }

    @Given("Send Update request to update student")
    public void sendUpdateRequestToUpdateStudent() {
        api.sendPUTRequest("22345", "James", "Kos", "3A", "Singapore");

    }

    @Given("Send Get request to retrieve student")
    public void sendGetRequestToRetrieveStudent() {
        api.sendGetRequestForAllStudents();
    }

    @Then("Status code is <200>")
    public void statusCodeIs(int responseCode) {
        api.validateStatusCodeToBe(responseCode);
    }

    @Then("Verify lastname is updated")
    public void verifyLastnameIsUpdated() {
        api.verifyResponseBody("lastName", "Kos");
    }
}
