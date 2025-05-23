package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class LoginTests extends BaseTest {

    @Test(groups = "login")
    public void testLoginWithValidCredentials() {
        System.out.println("testLoginWithValidCredentials executed.");
    }


    @Test(groups = "login")
    public void testLoginWithInvalidPassword() {
        System.out.println("testLoginWithInvalidPassword executed.");
    }

}