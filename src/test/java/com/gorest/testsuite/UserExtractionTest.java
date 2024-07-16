package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {

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

    //Extract the All Ids
    @Test
    public void extractAllIds(){
        List<?> ids=response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + ids.size());
        System.out.println("------------------End of Test---------------------------");

    }

   // Extract the all Names

    @Test
    public void allNames(){
        List<String> names=response.extract().path("name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + names);
        System.out.println("------------------End of Test---------------------------");

    }
    //Extract the name of 5th object
@Test
    public void nameOfFifthObject(){
        String nameOfFifth=response.extract().path("[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfFifth);
        System.out.println("------------------End of Test---------------------------");

    }

    //Extract the names of all object whose status = inactive

    @Test
    public void nameOfAllObjectStatusInactive(){
        List<String> nameOfFifth=response.extract().path("findAll{it.status=='inactive'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfFifth);
        System.out.println("------------------End of Test---------------------------");

    }
//Extract the gender of all the object whose status = active
    @Test
    public void nameOfAllObjectGenderActive(){
        List<String> nameOfGender=response.extract().path("findAll{it.status=='active'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfGender);
        System.out.println("------------------End of Test---------------------------");

    }

    //Print the names of the object whose gender = female
    @Test
    public void nameOfAllObjectGenderFemale(){
        List<String> nameOfFemale=response.extract().path("findAll{it.gender=='female'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfFemale);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the emails of the object where status = inactive

    @Test
    public void nameOfAllEmails(){
        List<String> nameOfEmail=response.extract().path("findAll{it.status=='inactive'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfEmail);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get the ids of the object where gender = male

    @Test
    public void nameOfAllIds(){
        List<String> nameOfId=response.extract().path("findAll{it.gender=='male'}.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfId);
        System.out.println("------------------End of Test---------------------------");

    }
    //Get all the status
    @Test
    public void nameOfAllStatus(){
        List<String> nameOfStatus=response.extract().path("status");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameOfStatus);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get email of the object where name = Lal Dwivedi
    @Test
    public void nameOfGorakhanta(){
        List<String> nameGora=response.extract().path("findAll{it.name=='Gorakhanatha Pillai'}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameGora);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get gender of id = 5914189
    @Test
    public void getId(){
        List<?> nameId=response.extract().path("findAll{it.id=='7015044'}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + nameId);
        System.out.println("------------------End of Test---------------------------");

    }
















































    @Test
    public void test01() {
        List<?> totalId= response.extract().path("id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total ids are : " + totalId.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void test04() {
        List<?> allInActiveStatus = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Status of Inactive: " + allInActiveStatus);
        System.out.println("------------------End of Test---------------------------");
    }
}
