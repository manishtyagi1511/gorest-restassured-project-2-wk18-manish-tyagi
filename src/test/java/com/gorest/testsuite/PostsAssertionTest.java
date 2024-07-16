package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest {
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
    //Verify if the total record is 25
    @Test
    public void verifyTotal(){
        response.body("size()",equalTo(25));
    }

    //Verify the if the title of id = 93997 is equal to ”Demitto conqueror atavus argumentum corrupti
    //cohaero libero.”
@Test
    public void verifyId(){
        response.body("[0].title",equalTo("Defaeco in carbo decet audeo volutabrum corroboro."));
    }

    //Check the single user_id in the Array list (5914249)
    @Test
    public void singleUserIdArrayList(){
        response.body("[7].user_id",equalTo(7015112));
    }

    //Check the multiple ids in the ArrayList
    @Test
    public void multipleIds(){
        response.body("id",hasItems(139914,139909,139907));

    }
    //Verify the body of userid = 5914197 is equal
    @Test
    public void userId(){
        response.body("[3].body",equalTo("Ocer arcus somniculosus. Rerum claro subito. Tollo aqua tracto. Rerum usitas confugo. Bardus eum vulticulus. Sub demitto aspernatur. Averto deorsum considero. Architecto audio angelus. Adicio quos tardus. Est damno accedo. Verto sint tubineus. Brevis cruentus quae."));

    }








}
