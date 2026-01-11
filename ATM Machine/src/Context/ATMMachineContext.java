package Context;

import ATM.ATMInventory;
import ATMAutomata.ATMAutomata;
import Account.Account;
import Account.Card;
import RelativeEnums.ATMStates;
import RelativeEnums.CashType;
import RelativeEnums.SelectedOperation;
import ATMAutomata.ATMStateFactory;

import java.util.HashMap;
import java.util.Map;

public class ATMMachineContext {
    private ATMAutomata currentStage;
    private Card currentCard;
    private Account currentAccount;
    private final ATMInventory atmInventory;
    private final Map<String, Account> accounts;
    private SelectedOperation selectedOperation;

    public ATMMachineContext() {
        this.currentStage = ATMStateFactory.nextATMState(ATMStates.IDLE_STATE);
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM initialized in: " + this.currentStage.getStateName());
    }

    public void advanceState() {
        this.currentStage = this.currentStage.setNextState(this);
        System.out.println("Current state: " + this.currentStage.getStateName());
    }

    public void insertCard(Card card){
        if (this.currentStage.getStateName() == ATMStates.IDLE_STATE) {
            System.out.println("Card inserted");
            this.currentCard = card;
            advanceState();
        } else {
            System.out.println(
                    "Cannot insert card in " + this.currentStage.getStateName());
        }
    }

    public void enterPin(int pin) {
        if (this.currentStage.getStateName() == ATMStates.HAS_CARD_STATE){
            if (this.currentCard.validatePin(pin)) {
                System.out.println("PIN authenticated successfully");
                this.currentAccount = accounts.get(currentCard.getAccountNumber());
                advanceState();
            } else {
                System.out.println("Invalid PIN. Please try again");
            }
        }
        else {
            System.out.println("Cannot enter PIN in " + this.currentStage.getStateName());
        }
    }

    public void selectOperation(SelectedOperation selectedOperation) {
        if (this.currentStage.getStateName() == ATMStates.SELECT_MENU_STATE) {
            System.out.println("Selected operation: " + selectedOperation);
            this.selectedOperation = selectedOperation;
            advanceState();
        } else {
            System.out.println(
                    "Cannot select operation in " + this.currentStage.getStateName());
        }
    }

    public void performTransaction(double amount) {
        if (this.currentStage.getStateName() == ATMStates.TRANSACTION_STATE) {
            try {
                if (selectedOperation == SelectedOperation.WITHDRAW_CASH) {
                    performWithdrawal(amount);
                } else if (selectedOperation == SelectedOperation.CHECK_BALANCE) {
                    checkBalance();
                }
                advanceState();
            } catch (Exception e) {
                System.out.println("Transaction failed: " + e.getMessage());
                this.currentStage = ATMStateFactory.nextATMState(ATMStates.SELECT_MENU_STATE);
            }
        } else {
            System.out.println(
                    "Cannot perform transaction in " + this.currentStage.getStateName());
        }
    }

    private void performWithdrawal(double amount) throws Exception {
        if (!currentAccount.withdrawBalance(amount)) {
            throw new Exception("Insufficient funds in account");
        }
        if (!atmInventory.hasSufficientCash((int) amount)) {
            throw new Exception("Insufficient cash in ATM");
        }
        Map<CashType, Integer> dispensedCash =
                atmInventory.dispenseCash((int) amount);
        if (dispensedCash == null) {
            throw new Exception("Unable to dispense exact amount");
        }
        System.out.println("Transaction successful. Please collect your cash:");
        for (Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " x $" + entry.getKey().getNote());
        }
    }

    public void returnCard() {
        if (currentStage.getStateName() == ATMStates.HAS_CARD_STATE
                || currentStage.getStateName() == ATMStates.SELECT_MENU_STATE
                || currentStage.getStateName() == ATMStates.TRANSACTION_STATE) {
            System.out.println("Card returned to customer");
            resetATM();
        } else {
            System.out.println("No card to return in " + currentStage.getStateName());
        }
    }

    public void cancelTransaction() {
        if (currentStage.getStateName() == ATMStates.TRANSACTION_STATE) {
            System.out.println("Transaction cancelled");
            returnCard();
        } else {
            System.out.println(
                    "No transaction to cancel in " + currentStage.getStateName());
        }
    }

    private void resetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedOperation = null;
        this.currentStage = ATMStateFactory.nextATMState(ATMStates.IDLE_STATE);
    }


    private void checkBalance() {
        System.out.println(
                "Your current balance is: $" + currentAccount.getBalance());
    }

    public ATMAutomata getCurrentState() {
        return this.currentStage;
    }

    public void setCurrentState(ATMAutomata currentStage) {
        this.currentStage = currentStage;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public ATMInventory getATMInventory() {
        return atmInventory;
    }

    public SelectedOperation getSelectedOperation() {
        return selectedOperation;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
