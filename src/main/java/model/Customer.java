package model;

/**
 * Customer model class
 */
public class Customer {
    private String fullName;
    private Account checkAccount;

    /**
     * The name of the customer
     * @return String full name of the customer
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     *  Set the name of the customer
     * @param fullName
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * return the account of the customer
     * @return
     */
    public Account getCheckAccount() {
        return checkAccount;
    }

    /**
     * set the account of the customer
     * @param checkAccount
     */
    public void setCheckAccount(final Account checkAccount) {
        this.checkAccount = checkAccount;
    }
}
