package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {1, 2, 3, 4};
    private static final int TOO_BIG_NUMBER = 17;

    @Before
    public void prepare() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorShouldCreateValidDatabase() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertEquals("Count of elements is incorrect", dbElements.length, NUMBERS.length);
        for (int i = 0; i < NUMBERS.length; i++) {
            Assert.assertEquals("We have different elements in the database", dbElements[i], NUMBERS[i]);
        }
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] largeArray = new Integer[TOO_BIG_NUMBER];
        new Database(largeArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionForLessThan1Elements() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[0];
        new Database(smallArray);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddThrowsExceptionWithNullArgument() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddElement() throws OperationNotSupportedException {
        database.add(6);
        Integer[] dbElement = database.getElements();
        Assert.assertEquals(NUMBERS.length + 1, dbElement.length);
        Assert.assertEquals(dbElement[dbElement.length - 1], Integer.valueOf(6));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(NUMBERS.length - 1), dbElements[dbElements.length - 1]);
    }
}