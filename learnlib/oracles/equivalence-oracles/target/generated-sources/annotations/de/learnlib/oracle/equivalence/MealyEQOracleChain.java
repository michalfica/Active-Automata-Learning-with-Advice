package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.SafeVarargs;
import java.util.List;
import net.automatalib.automaton.transducer.MealyMachine;
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
public class MealyEQOracleChain<I, O> extends EQOracleChain<MealyMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MealyEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link EQOracleChain#public transient void <init>(EquivalenceOracle[])}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    @SafeVarargs
    public MealyEQOracleChain(EquivalenceOracle.MealyEquivalenceOracle<I, O>... oracles) {
        super(oracles);
    }

    /**
     * Delegates to {@link EQOracleChain#public void <init>(List)}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    public MealyEQOracleChain(
            List<? extends EquivalenceOracle.MealyEquivalenceOracle<I, O>> oracles) {
        super(oracles);
    }
}
