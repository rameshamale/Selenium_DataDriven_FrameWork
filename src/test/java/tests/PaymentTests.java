package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class PaymentTests extends BaseTest {

    @Test(groups = "payment")
    public void testPaymentWithValidCard() {
        System.out.println("testPaymentWithValidCard executed.");
    }


    @Test(groups = "payment")
    public void testPaymentWithInvalidCard() {
        System.out.println("testPaymentWithInvalidCard executed.");
    }

}