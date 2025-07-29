package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.lang.SafeVarargs;
import java.util.List;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link EQOracleChain}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.EQOracleChain"
)
public class DFAEQOracleChain<I> extends EQOracleChain<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link EQOracleChain#public transient void <init>(EquivalenceOracle[])}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    @SafeVarargs
    public DFAEQOracleChain(EquivalenceOracle.DFAEquivalenceOracle<I>... oracles) {
        super(oracles);
    }

    /**
     * Delegates to {@link EQOracleChain#public void <init>(List)}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    public DFAEQOracleChain(List<? extends EquivalenceOracle.DFAEquivalenceOracle<I>> oracles) {
        super(oracles);
    }
}
