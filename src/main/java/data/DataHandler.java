package data;

import model.Customer;
import model.Operation;

import java.util.List;

/**
 * Interface to a database or webservice connector
 *
 */
public interface DataHandler {

    /**
     * connector to an external database or could be a webservice call.
     */
    void dataConnector();

    List<Operation> showCurrentBalance(final Customer customer);

    void deposit(final Customer customer, int amount, final String dateString) throws Exception;

    void withdraw(final Customer customer, int amount, final String dateString) throws Exception;
}
