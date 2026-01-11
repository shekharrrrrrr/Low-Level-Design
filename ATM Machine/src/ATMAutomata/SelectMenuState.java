package ATMAutomata;

import Context.ATMMachineContext;
import RelativeEnums.ATMStates;

public class SelectMenuState implements ATMAutomata{
    public SelectMenuState() {
        System.out.println("ATM is in Select Operation State - Please select an operation");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Check Balance");
    }
    @Override
    public ATMStates getStateName() {
        return ATMStates.SELECT_MENU_STATE;
    }

    @Override
    public ATMAutomata setNextState(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return ATMStateFactory.nextATMState(ATMStates.IDLE_STATE);
        }
        if (context.getSelectedOperation() != null) {
            return ATMStateFactory.nextATMState(ATMStates.TRANSACTION_STATE);
        }
        return this;
    }
}
