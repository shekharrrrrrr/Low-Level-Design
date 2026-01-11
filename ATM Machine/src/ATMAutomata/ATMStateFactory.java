package ATMAutomata;

import RelativeEnums.ATMStates;

public class ATMStateFactory {
    public static ATMAutomata nextATMState(ATMStates atmState){
        switch (atmState) {
            case ATMStates.IDLE_STATE -> {
                return new IdleState();
            }
            case ATMStates.HAS_CARD_STATE -> {
                return new HasCardState();
            }
            case ATMStates.SELECT_MENU_STATE -> {
                return new SelectMenuState();
            }
            case ATMStates.TRANSACTION_STATE -> {
                return new TransactionState();
            }
        }
        return new IdleState();
    }
}
