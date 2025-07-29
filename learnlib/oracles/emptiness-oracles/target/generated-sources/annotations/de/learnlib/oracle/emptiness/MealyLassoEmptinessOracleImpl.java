package de.learnlib.oracle.emptiness;

import de.learnlib.oracle.LassoEmptinessOracle;
import de.learnlib.oracle.LassoOracle;
import de.learnlib.oracle.OmegaMembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.modelchecking.Lasso;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link LassoEmptinessOracleImpl}.
 * @param <S> state type
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.emptiness.LassoEmptinessOracleImpl"
)
public class MealyLassoEmptinessOracleImpl<S, I, O> extends LassoEmptinessOracleImpl<Lasso.MealyLasso<I, O>, S, I, Word<O>> implements LassoEmptinessOracle.MealyLassoEmptinessOracle<I, O>, LassoOracle.MealyLassoOracle<I, O> {
    /**
     * Delegates to {@link LassoEmptinessOracleImpl#public void <init>(OmegaMembershipOracle)}.
     * @param omegaMembershipOracle maps to the {@code omegaMembershipOracle} parameter of the delegate
     */
    public MealyLassoEmptinessOracleImpl(
            OmegaMembershipOracle.MealyOmegaMembershipOracle<S, I, O> omegaMembershipOracle) {
        super(omegaMembershipOracle);
    }
}
