import data.DataHandlerSimulator;
import data.DataHandler;
import model.Account;
import model.Customer;
import model.Operation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class LifeBankAccountTest {

    private Customer customer;

    @Before
    public void initiateData() {

        // we set the basics data
        Account account = new Account();

        customer = new Customer();
        customer.setFullName("John Doe");
        customer.setCheckAccount(account);

    }

    /**
     * this test simulate movement into the main account of the customer "john doe"
     */
    @Test
    public void showBalanceHistoryTest() {
        DataHandler handlerSimulator = new DataHandlerSimulator();

        // I simulate the operations process.
        try {
            handlerSimulator.deposit(this.customer, 1000, "10/01/2012");
            handlerSimulator.deposit(this.customer, 2000, "13/01/2012");
            handlerSimulator.withdraw(this.customer,500, "14/01/2012");
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Operation> operations = handlerSimulator.showCurrentBalance(this.customer);

        System.out.println("Date       || Amount || Balance");
        for (Operation operation:
             operations ) {
            System.out.println(operation.toString());
        }

        assertEquals("14/01/2012 || -500 || 2500",  operations.get(0).toString());
        assertEquals("13/01/2012 || 2000 || 3000",  operations.get(1).toString());
        assertEquals("10/01/2012 || 1000 || 1000",  operations.get(2).toString());
    }
}
