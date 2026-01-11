package ATMAutomata;

import Context.ATMMachineContext;
import RelativeEnums.ATMStates;

public interface ATMAutomata {
    ATMStates getStateName();
    ATMAutomata setNextState(ATMMachineContext context);
}