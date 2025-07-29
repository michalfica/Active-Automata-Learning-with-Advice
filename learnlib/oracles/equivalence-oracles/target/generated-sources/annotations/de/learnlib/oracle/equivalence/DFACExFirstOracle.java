package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.BlackBoxOracle;
import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.PropertyOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.util.Collection;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link CExFirstOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.CExFirstOracle"
)
public class DFACExFirstOracle<I> extends CExFirstOracle<DFA<?, I>, I, Boolean> implements BlackBoxOracle.DFABlackBoxOracle<I>, EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link CExFirstOracle#public void <init>()}.
     */
    public DFACExFirstOracle() {
        super();
    }

    /**
     * Delegates to {@link CExFirstOracle#public void <init>(PropertyOracle)}.
     * @param propertyOracle maps to the {@code propertyOracle} parameter of the delegate
     */
    public DFACExFirstOracle(PropertyOracle.DFAPropertyOracle<I, ?> propertyOracle) {
        super(propertyOracle);
    }

    /**
     * Delegates to {@link CExFirstOracle#public void <init>(Collection)}.
     * @param propertyOracles maps to the {@code propertyOracles} parameter of the delegate
     */
    public DFACExFirstOracle(
            Collection<? extends PropertyOracle.DFAPropertyOracle<I, ?>> propertyOracles) {
        super(propertyOracles);
    }
}
