package de.learnlib.filter.statistic.oracle;

import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;

/**
 * A type-specific refinement of {@link CounterOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.oracle.CounterOracle"
)
public class DFACounterOracle<I> extends CounterOracle<I, Boolean> implements MembershipOracle.DFAMembershipOracle<I> {
    /**
     * Delegates to {@link CounterOracle#public void <init>(MembershipOracle)}.
     * @param delegate maps to the {@code delegate} parameter of the delegate
     */
    public DFACounterOracle(MembershipOracle.DFAMembershipOracle<I> delegate) {
        super(delegate);
    }
}
