package de.learnlib.filter.statistic.oracle;

import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.lang.String;

/**
 * A type-specific refinement of {@link HistogramOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.oracle.HistogramOracle"
)
public class DFAHistogramOracle<I> extends HistogramOracle<I, Boolean> implements MembershipOracle.DFAMembershipOracle<I> {
    /**
     * Delegates to {@link HistogramOracle#public void <init>(MembershipOracle, String)}.
     * @param next maps to the {@code next} parameter of the delegate
     * @param name maps to the {@code name} parameter of the delegate
     */
    public DFAHistogramOracle(MembershipOracle.DFAMembershipOracle<I> next, String name) {
        super(next, name);
    }
}
