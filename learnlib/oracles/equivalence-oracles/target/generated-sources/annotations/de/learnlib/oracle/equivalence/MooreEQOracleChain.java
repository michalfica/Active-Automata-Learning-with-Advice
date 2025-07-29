package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.SafeVarargs;
import java.util.List;
import net.automatalib.automaton.transducer.MooreMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link EQOracleChain}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.EQOracleChain"
)
public class MooreEQOracleChain<I, O> extends EQOracleChain<MooreMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MooreEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link EQOracleChain#public transient void <init>(EquivalenceOracle[])}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    @SafeVarargs
    public MooreEQOracleChain(EquivalenceOracle.MooreEquivalenceOracle<I, O>... oracles) {
        super(oracles);
    }

    /**
     * Delegates to {@link EQOracleChain#public void <init>(List)}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    public MooreEQOracleChain(
            List<? extends EquivalenceOracle.MooreEquivalenceOracle<I, O>> oracles) {
        super(oracles);
    }
}
