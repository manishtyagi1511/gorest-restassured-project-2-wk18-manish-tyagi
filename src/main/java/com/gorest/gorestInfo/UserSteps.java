package com.gorest.gorestInfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class UserSteps {

    @Step("Create user id")
    public ValidatableResponse createUserId(String name, String email, String gender, String status){

        UserPojo userPojo = UserPojo.getUserPojo(name,email,gender,status);

        return SerenityRest
                .given()
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post(EndPoints.CREATE_USER).then();

    }
    @Step("Read the user id ")
    public ValidatableResponse readUserId(int userId){

        return SerenityRest
                .given().log().all()
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .header("Content-Type", "application/json")
                .pathParam("userID",userId)
                .when()
                .get(EndPoints.GET_USER_BY_ID)
                .then();
    }



    @Step("Update the User ID")
    public ValidatableResponse updateTheUserId(int userId,String name, String email, String gender, String status){

        UserPojo userPojo=UserPojo.getUserPojo(name,email,gender,status);

        return SerenityRest
                .given()
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .header("Content-Type", "application/json")
                .pathParam("userID",userId)
                .when()
                .body(userPojo)
                .put(EndPoints.PATCH_USER_BY_ID).then();

    }





    @Step("Delete the user id ")
    public ValidatableResponse deleteUserId(int userId){


        return SerenityRest
                .given()
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                .header("Connection", "keep-alive")
                .pathParam("userID",userId)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID).then();
    }


}
