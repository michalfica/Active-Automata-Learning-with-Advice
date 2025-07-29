package de.learnlib.filter.statistic.oracle;

import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link CounterOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.oracle.CounterOracle"
)
public class MooreCounterOracle<I, O> extends CounterOracle<I, Word<O>> implements MembershipOracle.MooreMembershipOracle<I, O> {
    /**
     * Delegates to {@link CounterOracle#public void <init>(MembershipOracle)}.
     * @param delegate maps to the {@code delegate} parameter of the delegate
     */
    public MooreCounterOracle(MembershipOracle.MooreMembershipOracle<I, O> delegate) {
        super(delegate);
    }
}
