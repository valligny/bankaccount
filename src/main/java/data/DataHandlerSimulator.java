package data;

import model.Customer;
import model.Operation;

import java.text.ParseException;
import java.util.List;

/**
 * This class simulate an access to a database handler, with short method
 */
public class DataHandlerSimulator implements DataHandler {

    private static final String THE_AMOUNT_SHOULD_ALWAYS_BE_POSITIVE = "The amount should always be positive";

    /**
     * constructor
     */
    public DataHandlerSimulator() {
        this.dataConnector();
    }

    /**
     * connector to an external database or could be a webservice call.
     */
    public void dataConnector() {
        // Do nothing for the exercise.
    }

    /**
     * show the current balance of the bank account for a specific customer
     * @param customer
     * @return
     */
    public List<Operation> showCurrentBalance(final Customer customer) {
        return customer.getCheckAccount().getBalanceHistory();
    }

    /**
     * Make a deposit
     * @param customer
     * @param amount
     * @param dateString
     * @throws Exception if the amount selected is negative
     */
    public void deposit(final Customer customer, int amount, final String dateString) throws Exception {
        if (amount < 1) {
            throw new Exception(THE_AMOUNT_SHOULD_ALWAYS_BE_POSITIVE);
        }
        else {
            int newBalance = customer.getCheckAccount().getBalance() + amount;
            updateBalanceOperation(customer, amount, dateString, newBalance);
        }
    }

    /**
     * make a withdraw
     * @param customer
     * @param amount
     * @param dateString
     * @throws Exception if the amount selected is negative
     */
    public void withdraw(final Customer customer, int amount, final String dateString) throws Exception {
        if (amount < 1) {
            throw new Exception(THE_AMOUNT_SHOULD_ALWAYS_BE_POSITIVE);
        }
        else {
            int newBalance = customer.getCheckAccount().getBalance() - amount;
            updateBalanceOperation(customer, -amount, dateString, newBalance);
        }
    }

    /**
     * private method to update the balance operation history in the bank accont.
     * @param customer the operation maker
     * @param amount the amount of the operation
     * @param dateString the date on a string format
     * @param newBalance the balance after the operation
     * @throws ParseException
     */
    private void updateBalanceOperation(final Customer customer, int amount, final String dateString, int newBalance) throws ParseException {
            customer.getCheckAccount().setBalance(newBalance);

            Operation currentOperation = new Operation();
            currentOperation.setDate(dateString);
            currentOperation.setAmount(amount);
            currentOperation.setBalance(newBalance);

            customer.getCheckAccount().getBalanceHistory().add(currentOperation);
    }
}
