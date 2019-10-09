package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Operation {
    private static final String SEPARATOR = " || ";
    private static final String FORMAT_DATE = "dd/MM/y";
    private int amount;
    private Calendar date;
    private int balance;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * get the date of the operation
     * @return
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * set the time at the format "month/day/full year" (12/05/2019) for the 5th december 2019.
     * @param stringDate
     * @throws ParseException
     */
    public void setDate(final String stringDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE, Locale.CANADA);
        this.date = Calendar.getInstance();
        this.date.setTime(sdf.parse(stringDate));
    }

    public int getBalance() {
        return balance;
    }

    /**
     * Set the new account's balance
     * @param balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE, Locale.CANADA);
        String stringValue = sdf.format(this.date.getTime());
        stringValue += SEPARATOR;
        stringValue += this.amount;
        stringValue += SEPARATOR;
        stringValue += this.balance;
        return stringValue;
    }
}
