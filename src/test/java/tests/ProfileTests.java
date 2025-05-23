package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class ProfileTests extends BaseTest {

    @Test(groups = "profile")
    public void testUpdateProfileInfo() {
        System.out.println("testUpdateProfileInfo executed.");
    }


    @Test(groups = "profile")
    public void testChangePassword() {
        System.out.println("testChangePassword executed.");
    }

}