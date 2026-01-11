package Account;

public class Card {
    private final String cardNumber;
    private final int pin;
    private final String accountNumber;

    public Card(String cardNumber, String accountNumber, int pin){
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    public String getCardNumber(){
        return this.cardNumber;
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public boolean validatePin(int enteredPin){
        return enteredPin == this.pin;
    }
    
}
