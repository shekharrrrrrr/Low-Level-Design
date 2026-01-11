package ATMAutomata;

import Context.ATMMachineContext;
import RelativeEnums.ATMStates;

public class TransactionState implements ATMAutomata{
    public TransactionState() {
        System.out.println("ATM is in Transaction State");
    }
    @Override
    public ATMStates getStateName() {
        return ATMStates.TRANSACTION_STATE;
    }

    @Override
    public ATMAutomata setNextState(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return ATMStateFactory.nextATMState(ATMStates.IDLE_STATE);
        }

        return ATMStateFactory.nextATMState(ATMStates.SELECT_MENU_STATE);
    }
}
