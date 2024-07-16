package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users?page=1&per_page=20")
                .then().statusCode(200);
    }

    //    Verify the if the total record is 20
    @Test
    public void verifyTotal() {
        response.body("size()", equalTo(20));

    }

    // Verify the if the name of id = 5914197 is equal to ”Bhilangana Dhawan”
    @Test
    public void verifyTotal1() {
        //  response.body("[0].name",equalTo("Kamalesh Dhawan"));
        response.body("[0].id", equalTo(7015053));
        response.body("[0].name", equalTo("Msgr. Bandhul Bandopadhyay"));

    }

    //Check the single ‘Name’ in the Array list (Dev Bhattacharya)
    @Test
    public void verifyName() {
        response.body("[3].name", equalTo("Menka Marar"));
    }

    //Check the multiple ‘Names’ in the ArrayList (Usha Kaul Esq., Akshita Mishra, Chetanaanand Reddy )
    @Test
    public void verifyThreeName() {
//        response.body("[4].name", equalTo("Nawal Johar"))
//                .body("[5].name", equalTo("Dhanapati Mishra"))
//                .body("[6].name", equalTo("Daevika Menon"));

        response.body("name", hasItems("Nawal Johar", "Dhanapati Mishra", "Daevika Menon"));


    }

    //Verify the emai of userid = 5914185 is equal “tandon_iv_aanandinii@prosacco.example”
    @Test
    public void verifyemail() {
        response.body("[7].email", equalTo("patel_urmila@rowe-abernathy.example"));
    }

    //Verify the status is “Active” of user name is “Amaresh Rana”

    @Test
    public void verifyStatus() {
        response.body("[10].status", equalTo("active"));
    }

    //Verify the Gender = male of user name is “Dhanalakshmi Pothuvaal”
    @Test
    public void verifyGender() {
        response.body("[11].gender", equalTo("male"));

    }
}


