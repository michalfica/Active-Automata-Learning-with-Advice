package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.BlackBoxOracle;
import de.learnlib.oracle.PropertyOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.Collection;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link DisproveFirstOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.DisproveFirstOracle"
)
public class MealyDisproveFirstOracle<I, O> extends DisproveFirstOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements BlackBoxOracle.MealyBlackBoxOracle<I, O> {
    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>()}.
     */
    public MealyDisproveFirstOracle() {
        super();
    }

    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>(PropertyOracle)}.
     * @param propertyOracle maps to the {@code propertyOracle} parameter of the delegate
     */
    public MealyDisproveFirstOracle(PropertyOracle.MealyPropertyOracle<I, O, ?> propertyOracle) {
        super(propertyOracle);
    }

    /**
     * Delegates to {@link DisproveFirstOracle#public void <init>(Collection)}.
     * @param propertyOracles maps to the {@code propertyOracles} parameter of the delegate
     */
    public MealyDisproveFirstOracle(
            Collection<? extends PropertyOracle.MealyPropertyOracle<I, O, ?>> propertyOracles) {
        super(propertyOracles);
    }
}
