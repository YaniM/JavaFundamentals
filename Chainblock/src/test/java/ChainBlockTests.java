import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ChainBlockTests {
    private static final int INITIAL_ID = 1;
    private static final TransactionStatus TRANSACTION_STATUS = TransactionStatus.SUCCESSFUL;
    private static final String SENDER = "Sender";
    private static final String RECEIVER = "Receiver";
    private static final double INITIAL_AMOUNT = 12.0;

    private static final Transaction TRANSACTION = new TransactionImpl(INITIAL_ID, TRANSACTION_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT);
    private static final int RECORD_COUNT = 1;
    private static final TransactionStatus NEW_TRANSACTION_STATUS = TransactionStatus.ABORTED;

    private static final TransactionStatus[] ALL_TRANSACTIONS = TransactionStatus.values();

    private static final String[] SENDERS_AND_RECEIVERS = new String[]{
            "First",
            "Second",
            "Third",
            "Fourth"
    };

    private static final double[] amouns = new double[]{
            1.0,
            2.0,
            3.0,
            4.0,
    };

    private Chainblock chainblock;

    @Before
    public void createChainblock() {
        this.chainblock = new ChainblockImpl();
    }


    @Test
    public void constructorShouldInitialzeRecordDataStructure() {
        Assert.assertNotNull(this.chainblock.getRecord());
    }

    @Test
    public void addShouldIncreaseSize() {
        this.chainblock.add(TRANSACTION);
        Assert.assertEquals(RECORD_COUNT, this.chainblock.getCount());
    }

    @Test
    public void addShouldNotIncreaseCountWhenAddingSameTranscationMultipleTimes() {
        for (int i = 0; i < 10; i++) {
            this.chainblock.add(TRANSACTION);
        }
        Assert.assertEquals(RECORD_COUNT, this.chainblock.getCount());
    }

    @Test
    public void containsShouldReturnTrueWhenTransactionIsPresent() {
        this.chainblock.add(TRANSACTION);
        Assert.assertTrue(chainblock.contains(TRANSACTION.getId()));
    }

    @Test
    public void containsShouldReturnFalseWhenTransactionIsNotPresent() {
        Assert.assertFalse(chainblock.contains(TRANSACTION.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeStatusWhenNoSuchTransactionPresentShouldThrowException() {
        this.chainblock.changeTransactionStatus(TRANSACTION.getId(), NEW_TRANSACTION_STATUS);
    }

    @Test
    public void changeStatusShouldSetNewValue() {
        this.chainblock.add(TRANSACTION);
        this.chainblock.changeTransactionStatus(TRANSACTION.getId(), NEW_TRANSACTION_STATUS);
        Assert.assertEquals(NEW_TRANSACTION_STATUS, TRANSACTION.getStatus());
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeShouldThrowExceptionWhenTransactionNotPresent() {
        this.chainblock.removeTransactionById(TRANSACTION.getId());
    }

    @Test
    public void removeShouldRemoveCorrectly() {
        this.chainblock.add(TRANSACTION);
        this.chainblock.removeTransactionById(TRANSACTION.getId());
        Assert.assertFalse(this.chainblock.contains(TRANSACTION.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowExceptionWithInvalidId() {
        this.chainblock.getById(TRANSACTION.getId());
    }

    @Test
    public void getByIdShouldReturnValidId() {
        this.chainblock.add(TRANSACTION);

        Assert.assertEquals(TRANSACTION.getId(), this.chainblock.getById(TRANSACTION.getId()).getId());
    }

    @Test
    public void getByTransactionStatusShouldReturnOnlyElementsWithCorrectStatus() {
        this.addTransactions(this.chainblock);
        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(TRANSACTION_STATUS);

        for (Transaction transaction : transactions) {
            Assert.assertEquals(TRANSACTION.getStatus(), transaction.getStatus());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowExceptionWhenNoElementsWithCurrentStatusArePresent() {
        this.addTransactionsWithOnlyOneStatus(this.chainblock);
        this.chainblock.getByTransactionStatus(NEW_TRANSACTION_STATUS);
    }

    @Test
    public void getByTransactionStatusShouldReturnSortedCollection() {
        this.addTransactions(this.chainblock);

        List<Transaction> transactions = (List<Transaction>) this.chainblock.getByTransactionStatus(TRANSACTION_STATUS);

        boolean isSorted = true;

        for (int i = 1; i < transactions.size(); i++) {
            if (transactions.get(i - 1).getAmount() < transactions.get(i).getAmount()) {
                isSorted = false;
                break;
            }
        }

        Assert.assertTrue(isSorted);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnCorrectSenders() {
        for (int i = 0; i < 4; i++) {

            TransactionStatus ts = i % 2 == 0 ? TransactionStatus.ABORTED : TRANSACTION_STATUS;

            this.chainblock.add(new TransactionImpl(
                    i,
                    ts,
                    SENDERS_AND_RECEIVERS[i],
                    SENDERS_AND_RECEIVERS[i],
                    amouns[i]

            ));
        }

        List<String> senders = (List<String>) this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);

        boolean containsAll = true;
        for (int i = 0; i < 4; i+=2) {
            if(!senders.contains(SENDERS_AND_RECEIVERS[i])){
                containsAll=false;
                break;
            }
        }

        Assert.assertTrue(containsAll);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSendersShouldThrowExceptionIfNotPresent(){
        this.chainblock.getAllSendersWithTransactionStatus(TRANSACTION_STATUS);
    }


    private void addTransactionsWithOnlyOneStatus(Chainblock chainblock) {
        for (int id = 0; id < 10; id++) {
            this.chainblock.add(new TransactionImpl(
                    id,
                    TRANSACTION_STATUS,
                    SENDER,
                    RECEIVER,
                    INITIAL_AMOUNT
            ));
        }
    }

    private void addTransactions(Chainblock chainblock) {
        for (int id = 0; id < 100; id++) {
            this.chainblock.add(new TransactionImpl(
                    id,
                    ALL_TRANSACTIONS[id % ALL_TRANSACTIONS.length],
                    SENDER,
                    RECEIVER,
                    INITIAL_AMOUNT * (id + 1) / 13
            ));
        }
    }

    private void addTransactionsWithDifferentSenders(Chainblock chainblock) {
        for (int id = 0; id < 100; id++) {
            this.chainblock.add(new TransactionImpl(
                    id,
                    ALL_TRANSACTIONS[id % ALL_TRANSACTIONS.length],
                    SENDER + "" + id,
                    RECEIVER,
                    INITIAL_AMOUNT * (id + 1) / 13
            ));
        }
    }
}
