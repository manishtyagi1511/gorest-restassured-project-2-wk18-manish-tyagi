package com.gorest.crudtest;

import com.gorest.gorestInfo.UserSteps;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCRUDTest extends TestBase {


    static String name = TestUtils.getRandomValue() + "Manish ";
    static String email = TestUtils.getRandomValue() + "manish123@gmail.com";
    static String gender = "male";
    static String status = "active";

    static int userId;
    @Steps
    UserSteps userSteps;

    @Title("Create User Id")
    @Test
    public void test001() {

        ValidatableResponse response = userSteps.createUserId(name, email, gender, status);

        response.log().all();
        response.statusCode(201);
        userId = response.extract().path("id");

    }

    @Title("Read user Id")
    @Test
    public void test002() {

        ValidatableResponse response = userSteps.readUserId(userId);
        response.statusCode(200);


    }

    @Title("Update the user id ")
    @Test
    public void test003() {
        ValidatableResponse response = userSteps.updateTheUserId(userId, name, email, gender, status);
        response.log().all();
        response.statusCode(200);
    }


    @Title("Delete the user ID")
    @Test
    public void test004() {

        ValidatableResponse response = userSteps.deleteUserId(userId);
        response.log().all();
        response.statusCode(204);
    }


}

