package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class WishlistTests extends BaseTest {

    @Test(groups = "wishlist")
    public void testAddToWishlist() {
        System.out.println("testAddToWishlist executed.");
    }


    @Test(groups = "wishlist")
    public void testRemoveFromWishlist() {
        System.out.println("testRemoveFromWishlist executed.");
    }

}