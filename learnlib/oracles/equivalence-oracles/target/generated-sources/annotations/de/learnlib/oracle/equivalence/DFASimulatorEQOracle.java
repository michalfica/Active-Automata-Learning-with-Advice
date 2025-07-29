package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link SimulatorEQOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.SimulatorEQOracle"
)
public class DFASimulatorEQOracle<I> extends SimulatorEQOracle<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link SimulatorEQOracle#public void <init>(net.automatalib.automaton.UniversalDeterministicAutomaton)}.
     * @param reference maps to the {@code reference} parameter of the delegate
     */
    public DFASimulatorEQOracle(DFA<?, I> reference) {
        super(reference);
    }
}
