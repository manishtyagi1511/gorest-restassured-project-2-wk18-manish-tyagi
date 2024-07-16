package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts?page=1&per_page=25")
                .then().statusCode(200);

    }

    //    1. Extract the title
    @Test
    public void test01() {
        List<?> title = response.extract().path("title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + title);
        System.out.println("------------------End of Test---------------------------");

    }


    //2. Extract the total number of record
    @Test
    public void test02() {
        List<?> record = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + record);
        System.out.println("------------------End of Test---------------------------");

    }


//3. Extract the body of 15th record

    @Test
    public void test03() {
        String fourteen = response.extract().path("[14].body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + fourteen);
        System.out.println("------------------End of Test---------------------------");

    }

//4. Extract the user_id of all the records

    @Test
    public void test04() {
        List<Object> userID1 = response.extract().path("user_id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + userID1);
        System.out.println("------------------End of Test---------------------------");

    }

    //5. Extract the title of all the records
    @Test
    public void test05() {
        List<Object> title1 = response.extract().path("title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + title1);
        System.out.println("------------------End of Test---------------------------");

    }


    //6. Extract the title of all records whose user_id = 5914200
    @Test
    public void test06() {

        List<String> userIDTitle = response.extract().path("findAll{it.user_id==7015118}.title");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + userIDTitle);
        System.out.println("------------------End of Test---------------------------");

    }

//7. Extract the body of all records whose id = 93957

    @Test
    public void test07() {

       List<?> userIDTitle1 = response.extract().path("findAll{it.id==139914}.body");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total records are : " + userIDTitle1);
        System.out.println("------------------End of Test---------------------------");

    }



}