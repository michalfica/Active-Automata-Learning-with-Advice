package de.learnlib.oracle.membership;

import de.learnlib.oracle.SingleQueryOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.procedural.SPMM;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link SimulatorOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.membership.SimulatorOracle"
)
public class SPMMSimulatorOracle<I, O> extends SimulatorOracle<I, Word<O>> implements SingleQueryOracle.SingleQueryOracleMealy<I, O> {
    /**
     * Delegates to {@link SimulatorOracle#public void <init>(net.automatalib.automaton.concept.SuffixOutput)}.
     * @param automaton maps to the {@code automaton} parameter of the delegate
     */
    public SPMMSimulatorOracle(SPMM<?, I, ?, O> automaton) {
        super(automaton);
    }
}
