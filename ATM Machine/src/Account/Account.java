package Account;

public class Account {
    private final String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean withdrawBalance(double withdrawAmount) {
        if (withdrawAmount > this.balance){
            return false;
        }
        this.balance -= withdrawAmount;
        return true;
    }
}
