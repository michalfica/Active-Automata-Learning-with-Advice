package de.learnlib.oracle.membership;

import de.learnlib.oracle.SingleQueryOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MooreMachine;
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
public class MooreSimulatorOracle<I, O> extends SimulatorOracle<I, Word<O>> implements SingleQueryOracle.SingleQueryOracleMoore<I, O> {
    /**
     * Delegates to {@link SimulatorOracle#public void <init>(net.automatalib.automaton.concept.SuffixOutput)}.
     * @param automaton maps to the {@code automaton} parameter of the delegate
     */
    public MooreSimulatorOracle(MooreMachine<?, I, ?, O> automaton) {
        super(automaton);
    }
}
