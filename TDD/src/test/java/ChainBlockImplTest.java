import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainBlockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactions;

    @Before
    public void prepare() {
        this.chainblock = new ChainBlockImpl();
        this.transactions = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction transaction = new TransactionImpl(0, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 10.20);
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Pesho", "Toshko", 0.0);
        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.UNAUTHORIZED, "Sasho", "Pesho", 11);
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.FAILED, "Tasho", "Toshko", 12.20);

        this.transactions.add(transaction);
        this.transactions.add(transaction1);
        this.transactions.add(transaction2);
        this.transactions.add(transaction3);
    }

    private void fillChainBlockWithTransactions() {
        this.transactions
                .forEach(existingTransaction -> this.chainblock.add(existingTransaction));
    }

    @Test
    public void testContainsReturnTrue() {
        Transaction transaction = transactions.get(0);
        chainblock.add(transaction);
        Assert.assertTrue(this.chainblock.contains(transaction));
    }

    @Test
    public void testContainsReturnFalse() {
        Transaction transaction = transactions.get(0);
        Assert.assertFalse(this.chainblock.contains(transaction));
    }

    @Test
    public void testContainsByIdReturnsTrue() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        Assert.assertTrue(this.chainblock.contains(0));
    }

    @Test
    public void testContainsByIdReturnsFalse() {
        Assert.assertFalse(this.chainblock.contains(0));
    }

    @Test
    public void testAddCorrectTransactionSuccess() {
        Transaction transaction = this.transactions.get(0);
        Transaction transaction1 = this.transactions.get(1);

        this.chainblock.add(transaction);
        Assert.assertEquals(1, this.chainblock.getCount());

        this.chainblock.add(transaction1);
        Assert.assertEquals(2, this.chainblock.getCount());
    }

    @Test
    public void testAddTransactionFail() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        this.chainblock.add(transaction);
        Assert.assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void testGetCount() {
        Transaction transaction = this.transactions.get(0);
        Transaction transaction1 = this.transactions.get(1);
        Assert.assertEquals(0, chainblock.getCount());

        this.chainblock.add(transaction);
        Assert.assertEquals(1, chainblock.getCount());

        this.chainblock.add(transaction1);
        Assert.assertEquals(2, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeInvalidTransactionStatus() {
        this.chainblock.changeTransactionStatus(100, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransactionStatusSuccess() {
        Transaction transaction = this.transactions.get(0);
        this.chainblock.add(transaction);
        Assert.assertNotEquals(TransactionStatus.UNAUTHORIZED, this.chainblock.getById(0).getStatus());

        this.chainblock.changeTransactionStatus(0, TransactionStatus.ABORTED);
        Assert.assertEquals(TransactionStatus.ABORTED, this.chainblock.getById(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithWrongId() {
        this.chainblock.getById(100);
    }

    @Test
    public void testGetByIdSuccess() {
        fillChainBlockWithTransactions();
        Transaction actualTransaction = this.chainblock.getById(0);
        Assert.assertEquals(0, actualTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionWithInvalidId() {
        fillChainBlockWithTransactions();
        this.chainblock.removeTransactionById(100);
    }

    @Test
    public void testRemoveTransactionByIdSuccess() {
        fillChainBlockWithTransactions();
        this.chainblock.removeTransactionById(0);
        Assert.assertEquals(3, this.chainblock.getCount());
        Assert.assertFalse(this.chainblock.contains(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWithWrongStatus() {
        fillChainBlockWithTransactions();
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusSuccess() {
        this.transactions
                .sort(Comparator.comparing(Transaction::getAmount).reversed());

        fillChainBlockWithTransactions();

        List<Transaction> successfulSortedTransactions = this.transactions
                .stream()
                .filter(transaction -> transaction.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .collect(Collectors.toList());

        Iterable<Transaction> actualSortedTransactions = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);

        List<Transaction> actualSortedTransactionsList = new ArrayList<>();
        actualSortedTransactions.forEach(actualSortedTransactionsList::add);

        Assert.assertEquals(successfulSortedTransactions, actualSortedTransactionsList);
    }

    @Test
    public void getAllInAmountRangeSuccess() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> resultTransactions = this.chainblock.getAllInAmountRange(10, 12);
        for (Transaction resultTransaction : resultTransactions) {
            Assert.assertTrue(resultTransaction.getAmount() >= 10);
            Assert.assertTrue(resultTransaction.getAmount() <= 12);
        }
    }

    @Test
    public void getAllInAmountRangeEmptyResult() {
        fillChainBlockWithTransactions();
        Iterable<Transaction> resultTransactions = this.chainblock.getAllInAmountRange(100, 200);
        List<Transaction> resultList = new ArrayList<>();
        resultTransactions.forEach(t -> resultList.add(t));
        Assert.assertTrue(resultList.isEmpty());
    }
}


















