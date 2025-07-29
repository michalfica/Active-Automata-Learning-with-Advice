package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.BlackBoxOracle;
import de.learnlib.oracle.PropertyOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.util.Collection;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link DisproveFirstOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.DisproveFirstOracle"
)
public class DFADisproveFirstOracle<I> extends DisproveFirstOracle<DFA<?, I>, I, Boolean> implements BlackBoxOracle.DFABlackBoxOracle<I> {
    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>()}.
     */
    public DFADisproveFirstOracle() {
        super();
    }

    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>(PropertyOracle)}.
     * @param propertyOracle maps to the {@code propertyOracle} parameter of the delegate
     */
    public DFADisproveFirstOracle(PropertyOracle.DFAPropertyOracle<I, ?> propertyOracle) {
        super(propertyOracle);
    }

    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>(Collection)}.
     * @param propertyOracles maps to the {@code propertyOracles} parameter of the delegate
     */
    public DFADisproveFirstOracle(
            Collection<? extends PropertyOracle.DFAPropertyOracle<I, ?>> propertyOracles) {
        super(propertyOracles);
    }
}
