/*
* Created on 10/11/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.rest.patient;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = "spring.jpa.hibernate.ddl-auto=none",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class TestPatientController_V1
{
    @LocalServerPort
    int randomServerPort;

    @Before
    public void setUp()
    {
        RestAssured.port = randomServerPort;
    }

    @Test
    public void getPatientInPath()
    {
        JsonPath response = given()

                .log().all()
                .header("Content-type", "application/json")

                .when()

                .get("/patient/1")

                .then()

                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract().jsonPath();

        assertThat("first name", response.getString("firstName"), is("John"));
        assertThat("last name", response.getString("lastName"), is("McCarthy"));
        assertThat("DTO type", response.getString("key.typeKey"), is("Patient"));
        assertThat("DTO Version", response.getInt("key.typeVersion"), is(1));
    }
}
