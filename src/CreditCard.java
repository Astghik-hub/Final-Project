/**
 * This class defines a credit card using the Money and Person class
 */
public class CreditCard {
    // The balance of the person
    private Money balance;
    // The credit limit of the person
    private Money creditLimit;
    // the owner of the account
    private Person owner;

    /**
     * Constructor
     *
     * @param newCardHolder the owner of the account
     * @param limit         the credit limit of the person
     */
    public CreditCard(Person newCardHolder, Money limit) {
        owner = newCardHolder;
        creditLimit = new Money(limit);
        balance = new Money(0);
    }

    /**
     * get method for balance
     *
     * @return the balance
     */
    public Money getBalance() {
        return new Money(balance);
    }

    /**
     * get method for credit limit
     *
     * @return the credit limit
     */
    public Money getCreditLimit() {
        return new Money(creditLimit);
    }

    /**
     * get method for the owners personal information
     *
     * @return the personal information
     */
    public String getPersonals() {
        return owner.toString();
    }

    /**
     * method that charges to the CreditCard by adding the amount
     * passed in the parameter to the balance, but only if
     * it will not exceed the creditLimit.
     *
     * @param amount a certain amount of money
     */
    public void charge(Money amount) {
        Money tempBalance = new Money(balance);
        tempBalance = tempBalance.add(amount);
        if (creditLimit.compareTo(tempBalance) < 0) {
            System.out.println("Exceeds credit limit");
        } else {
            balance = tempBalance;
        }
    }

    /**
     * method that will make a payment on the CreditCard by subtracting
     * the amount passed in the parameter from the balance.
     *
     * @param amount a certain amount of money
     */
    public void payment(Money amount) {
        balance = balance.subtract(amount);
    }
}