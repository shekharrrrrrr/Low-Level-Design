import Account.Account;
import Context.ATMMachineContext;
import Account.Card;
import RelativeEnums.SelectedOperation;

void main() {
    ATMMachineContext atm = new ATMMachineContext();
    atm.addAccount(new Account("123456", 1000.0));
    atm.addAccount(new Account("654321", 500.0));

    try {
        System.out.println("=== Starting ATM Demo ===");
        atm.insertCard(new Card("123456", "654321", 1234));
        atm.enterPin(1234);
        atm.selectOperation(SelectedOperation.WITHDRAW_CASH);
        atm.performTransaction(100.0);
        atm.selectOperation(SelectedOperation.CHECK_BALANCE);
        atm.performTransaction(0.0);
        atm.returnCard();
        System.out.println("=== ATM Demo Completed ===");

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
