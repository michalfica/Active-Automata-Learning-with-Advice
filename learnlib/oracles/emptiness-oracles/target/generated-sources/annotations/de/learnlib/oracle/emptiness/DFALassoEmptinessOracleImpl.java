package de.learnlib.oracle.emptiness;

import de.learnlib.oracle.LassoEmptinessOracle;
import de.learnlib.oracle.LassoOracle;
import de.learnlib.oracle.OmegaMembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.modelchecking.Lasso;

/**
 * A type-specific refinement of {@link LassoEmptinessOracleImpl}.
 * @param <S> state type
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.emptiness.LassoEmptinessOracleImpl"
)
public class DFALassoEmptinessOracleImpl<S, I> extends LassoEmptinessOracleImpl<Lasso.DFALasso<I>, S, I, Boolean> implements LassoEmptinessOracle.DFALassoEmptinessOracle<I>, LassoOracle.DFALassoOracle<I> {
    /**
     * Delegates to {@link LassoEmptinessOracleImpl#public void <init>(OmegaMembershipOracle)}.
     * @param omegaMembershipOracle maps to the {@code omegaMembershipOracle} parameter of the delegate
     */
    public DFALassoEmptinessOracleImpl(
            OmegaMembershipOracle.DFAOmegaMembershipOracle<S, I> omegaMembershipOracle) {
        super(omegaMembershipOracle);
    }
}
