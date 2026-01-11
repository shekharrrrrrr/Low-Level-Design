package ATM;

import RelativeEnums.CashType;

import java.util.*;

public class ATMInventory {
    private final Map<CashType, Integer> cashInventory;

    public ATMInventory(){
        cashInventory = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory(){
        cashInventory.put(CashType.BILL_500, 10);
        cashInventory.put(CashType.BILL_100, 10);
        cashInventory.put(CashType.BILL_50, 50);
        cashInventory.put(CashType.BILL_20, 20);
        cashInventory.put(CashType.BILL_10, 10);
        cashInventory.put(CashType.BILL_5, 20);
        cashInventory.put(CashType.BILL_1, 50);
    }

    public int getTotalCash() {
        int total = 0;
        for (Map.Entry<CashType, Integer> entry: cashInventory.entrySet() ){
            total += entry.getKey().getNote() * entry.getValue();
        }
        return  total;
    }

    public boolean hasSufficientCash(int amount) {
        return this.getTotalCash() >= amount;
    }

    public Map<CashType, Integer> dispenseCash(int amount) {
        if (!hasSufficientCash(amount)) {
            return null;
        }

        Map<CashType, Integer> dispensedCash = new HashMap<>();
        int remainingAmount = amount;

        List<CashType> cashTypesSorted = new ArrayList<>(Arrays.asList(CashType.values()));
        cashTypesSorted.sort((a, b) -> b.getNote() - a.getNote());

        for (CashType cashType : cashTypesSorted) {
            int noteValue = cashType.getNote();
            int availableNotes = cashInventory.get(cashType);

            int neededNotes = remainingAmount / noteValue;
            int notesToDispense = Math.min(neededNotes, availableNotes);

            if (notesToDispense > 0) {
                dispensedCash.put(cashType, notesToDispense);
                remainingAmount -= notesToDispense * noteValue;
            }
        }

        if (remainingAmount != 0) {
            return null;
        }

        for (Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            cashInventory.put(
                    entry.getKey(),
                    cashInventory.get(entry.getKey()) - entry.getValue()
            );
        }

        return dispensedCash;
    }

    public void addCash(CashType cashType, int count) {
        cashInventory.put(cashType, cashInventory.get(cashType) + count);
    }
}
