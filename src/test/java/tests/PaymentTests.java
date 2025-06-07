package tests;

import java.util.Map;

import org.testng.annotations.*;
import base.BaseTest;
import pages.PaymentPage;
import utils.TestUtil;

public class PaymentTests extends BaseTest {

	PaymentPage paymentPage;
    @Test(groups = "payment")
    public void testPaymentWithValidCard() {
        
    }

    @Test(groups = "payment")
    public void testPaymentWithInvalidCard() {
    }

}