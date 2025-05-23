package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class CheckoutTests extends BaseTest {

    @Test(groups = "checkout")
    public void testProceedToCheckoutWithCOD() {
        System.out.println("testProceedToCheckoutWithCOD executed.");
    }


    @Test(groups = "checkout")
    public void testProceedToCheckoutWithCard() {
        System.out.println("testProceedToCheckoutWithCard executed.");
    }

}