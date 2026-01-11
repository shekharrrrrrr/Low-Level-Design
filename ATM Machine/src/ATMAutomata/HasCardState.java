package ATMAutomata;

import Context.ATMMachineContext;
import RelativeEnums.ATMStates;

public class HasCardState implements ATMAutomata {

    public HasCardState() {
        System.out.println("ATM is in Has Card State - Please enter your PIN");
    }

    @Override
    public ATMStates getStateName() {
        return ATMStates.HAS_CARD_STATE;
    }

    @Override
    public ATMAutomata setNextState(ATMMachineContext context) {
        if (context.getCurrentCard() == null) {
            return ATMStateFactory.nextATMState(ATMStates.IDLE_STATE);
        }
        if (context.getCurrentAccount() != null) {
            return ATMStateFactory.nextATMState(ATMStates.SELECT_MENU_STATE);
        }
        return this;
    }

}
