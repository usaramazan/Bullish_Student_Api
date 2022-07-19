package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class StudentEditUtil {

    HashMap<String,String> map = new HashMap<String,String>();

    private Response response;


//    Retrieve student for id {id}
    public void sendGetRequestForStudentId(String studentId) {

        response = SerenityRest.given().queryParam("id", studentId).when().get("fetchStudents");
        response.prettyPrint();
    }

//    Fetch all the students data
    public void sendGetRequestForAllStudents() {

        response = SerenityRest.given().when().get("fetchStudents");
        response.prettyPrint();
    }

//    Retrieve data for students with studentClass: {0}
    public void sendGetRequestForStudentClass(String studentClass) {

        response = SerenityRest.given().queryParam("studentClass", studentClass).when().get("fetchStudents");
        response.prettyPrint();
    }

//    Retrieve data for students with studentId: {0} and studentClass: {1}
    public void sendGetRequestForStudentIdStudentClass(String studentId, String studentClass) {

        response = SerenityRest.given().queryParam("id", studentId).queryParam("studentClass", studentClass).when().get("fetchStudents");
        response.prettyPrint();
    }

//    Send POST request for user creating with studentId: {0}, firstname {1}, lastname {2}, studentClass {3} and studentNationality {4}
    public void sendPOSTRequest(String studentId, String firstName, String lastName, String studentClass, String studentNationality) {

        map.put("id", studentId);
        map.put("firstName", firstName);
        map.put("lastName", lastName);
        map.put("studentClass", studentClass);
        map.put("nationality", studentNationality);

        response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(map).log().all().post("/addStudent");
        ;
        response.prettyPrint();
    }


//    Send PUT request for updating Student Data with studentId: {0}, firstname {1}, lastname {2}, studentClass {3} and studentNationality {4}
    public void sendPUTRequest(String studentId, String firstName, String updatedLastName, String studentClass, String studentNationality) {

        map.put("id", studentId);
        map.put("firstName", firstName);
        map.put("lastName", updatedLastName);
        map.put("studentClass", studentClass);
        map.put("nationality", studentNationality);

        response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(map).log().all().put("/updateStudent");
        ;
        response.prettyPrint();
    }

//    Send Delete request for Student id: {0}
    public void sendDeleteRequestForStudent(String studentId) {

        map.put("id", studentId);
        response = SerenityRest.given().contentType(ContentType.JSON)
                .body(map).log().all().when().delete("deleteStudent");
        response.prettyPrint();
    }

//    Validate status code to be {0}
    public void validateStatusCodeToBe(int code) {

        response.then().statusCode(code);

    }

//    Verify response body for key {0} and value {1}"
    public void verifyResponseBody(String key,String value) {

        response.then().body(key, equalTo(value));

    }

//    Verify response body size for value {1}"
    public void verifyResponseBodySize(int value) {

        response.then().assertThat().body("size()", equalTo(value));

    }
}
