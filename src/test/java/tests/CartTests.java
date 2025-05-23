package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class CartTests extends BaseTest {

    @Test(groups = "cart")
    public void testAddProductToCart() {
        System.out.println("testAddProductToCart executed.");
    }


    @Test(groups = "cart")
    public void testRemoveProductFromCart() {
        System.out.println("testRemoveProductFromCart executed.");
    }


    @Test(groups = "cart")
    public void testUpdateCartQuantity() {
        System.out.println("testUpdateCartQuantity executed.");
    }

}