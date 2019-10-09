package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Account model class
 */
public class Account {
    private int balance;
    private List<Operation> balanceHistory;

    /**
     * New account create an empty account with empty history and 0$
     */
    public Account() {
        this.balance = 0;
        balanceHistory = new LinkedList<>();
    }

    /**
     * Set the new balance;
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * get the current balance
     * @return int current balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * show all the operations made on this account
     * @return the full account historic
     */
    public List<Operation> getBalanceHistory() {

        balanceHistory.sort(new Comparator<Operation>() {
            @Override
            public int compare(Operation o1, Operation o2) {
                return (int) (o2.getDate().getTimeInMillis() - o1.getDate().getTimeInMillis());
            }
        });
        return balanceHistory;
    }

}
