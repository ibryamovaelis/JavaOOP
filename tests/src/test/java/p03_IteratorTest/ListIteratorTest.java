package p03_IteratorTest;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] NAMES = new String[]{"Elis", "Kenan", "Ibryamova"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Elis", "Kenan", "Ibryamova");
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorShouldCreateListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("Elis", "Kenan", "Ibryamova");
    }

    @Test
    public void testHasNext() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.move());
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintShouldThrowExceptionForEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintSuccess() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(NAMES[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }
}