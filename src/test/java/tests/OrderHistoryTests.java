package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class OrderHistoryTests extends BaseTest {

    @Test(groups = "order")
    public void testViewOrderHistory() {
        System.out.println("testViewOrderHistory executed.");
    }


    @Test(groups = "order")
    public void testReorderProduct() {
        System.out.println("testReorderProduct executed.");
    }

}