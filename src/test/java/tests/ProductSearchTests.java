package tests;

import org.testng.annotations.*;
import base.BaseTest;

public class ProductSearchTests extends BaseTest {

    @Test(groups = "search")
    public void testSearchProductByName() {
        System.out.println("testSearchProductByName executed.");
    }


    @Test(groups = "search")
    public void testSearchProductByCategory() {
        System.out.println("testSearchProductByCategory executed.");
    }

}