package de.learnlib.oracle.property;

import de.learnlib.oracle.PropertyOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.SafeVarargs;
import java.util.Collection;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link PropertyOracleChain}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 * @param <P> property type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.property.PropertyOracleChain"
)
public class MealyPropertyOracleChain<I, O, P> extends PropertyOracleChain<I, MealyMachine<?, I, ?, O>, P, Word<O>> implements PropertyOracle.MealyPropertyOracle<I, O, P> {
    /**
     * Delegates to {@link PropertyOracleChain#public transient void <init>(PropertyOracle[])}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    @SafeVarargs
    public MealyPropertyOracleChain(PropertyOracle.MealyPropertyOracle<I, O, P>... oracles) {
        super(oracles);
    }

    /**
     * Delegates to {@link PropertyOracleChain#public void <init>(Collection)}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    public MealyPropertyOracleChain(
            Collection<? extends PropertyOracle.MealyPropertyOracle<I, O, P>> oracles) {
        super(oracles);
    }
}
