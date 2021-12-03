package shopAndGoods;


import org.junit.Before;
import org.junit.Test;


import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class ShopTest {
    // TODO

    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testGetShelvesShouldReturnUnmodifiableCollection() {
        shop.getShelves().clear();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("Invalid_test_shelf", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddGoodsShouldFailForExistingGood() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testAddGoodsShouldReturnCorrectMessageOnAddition() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        String expected = "Goods: test_code is placed successfully!";
        String actual = shop.addGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForNonExistingShelf() throws OperationNotSupportedException {
        shop.removeGoods("Invalid_test_shelf", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveGoodsShouldFailForDifferentGoodOnTheSameShelve() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        Goods goodsOther = new Goods("test_good_other", "test_code_other");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goodsOther);
    }

    @Test
    public void testRemoveGoodsShouldReturnCorrectMessageOnRemoval() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);
        String expected = "Goods: test_code is removed successfully!";
        String actual = shop.removeGoods("Shelves1", goods);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveGoodsShouldSetTheShelfValueToNull() throws OperationNotSupportedException {
        Goods goods = new Goods("test_good", "test_code");
        shop.addGoods("Shelves1", goods);

        shop.removeGoods("Shelves1", goods);

        Goods emptySlot = shop.getShelves().get("Shelves1");
        assertNull(emptySlot);
    }
}