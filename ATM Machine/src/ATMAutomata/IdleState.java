package ATMAutomata;

import Context.ATMMachineContext;
import RelativeEnums.ATMStates;

public class IdleState implements ATMAutomata {

    public IdleState() {
        System.out.println("ATM is in Idle State - Please insert your card");
    }

    @Override
    public ATMStates getStateName() {
        return ATMStates.IDLE_STATE;
    }

    @Override
    public ATMAutomata setNextState(ATMMachineContext context) {
       if (context.getCurrentCard() != null ){
           return ATMStateFactory.nextATMState(ATMStates.HAS_CARD_STATE);
       }
       return this;
    }
}
