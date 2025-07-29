package de.learnlib.oracle.membership;

import de.learnlib.oracle.SingleQueryOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.NFA;

/**
 * A type-specific refinement of {@link SimulatorOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.membership.SimulatorOracle"
)
public class NFASimulatorOracle<I> extends SimulatorOracle<I, Boolean> implements SingleQueryOracle.SingleQueryOracleDFA<I> {
    /**
     * Delegates to {@link SimulatorOracle#public void <init>(net.automatalib.automaton.concept.SuffixOutput)}.
     * @param automaton maps to the {@code automaton} parameter of the delegate
     */
    public NFASimulatorOracle(NFA<?, I> automaton) {
        super(automaton);
    }
}
