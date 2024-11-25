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

    public Money getBalance() {
        return new Money(balance);
    }

    public Money getCreditLimit() {
        return new Money(creditLimit);
    }

    public String getPersonals() {
        return owner.toString();
    }

    public void charge(Money amount) {
        Money tempBalance = new Money(balance);
        tempBalance = tempBalance.add(amount);
        if (creditLimit.compareTo(tempBalance) < 0) {
            System.out.println("Exceeds credit limit");
        } else {
            balance = tempBalance;
        }
    }

    public void payment(Money amount) {
        balance = balance.subtract(amount);
    }
}