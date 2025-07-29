package de.learnlib.oracle.property;

import de.learnlib.oracle.PropertyOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.lang.SafeVarargs;
import java.util.Collection;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link PropertyOracleChain}.
 * @param <I> input symbol type
 * @param <P> property type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.property.PropertyOracleChain"
)
public class DFAPropertyOracleChain<I, P> extends PropertyOracleChain<I, DFA<?, I>, P, Boolean> implements PropertyOracle.DFAPropertyOracle<I, P> {
    /**
     * Delegates to {@link PropertyOracleChain#public transient void <init>(PropertyOracle[])}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    @SafeVarargs
    public DFAPropertyOracleChain(PropertyOracle.DFAPropertyOracle<I, P>... oracles) {
        super(oracles);
    }

    /**
     * Delegates to {@link PropertyOracleChain#public void <init>(Collection)}.
     * @param oracles maps to the {@code oracles} parameter of the delegate
     */
    public DFAPropertyOracleChain(
            Collection<? extends PropertyOracle.DFAPropertyOracle<I, P>> oracles) {
        super(oracles);
    }
}
