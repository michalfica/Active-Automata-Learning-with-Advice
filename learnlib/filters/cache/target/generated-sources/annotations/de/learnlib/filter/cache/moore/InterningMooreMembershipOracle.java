package de.learnlib.filter.cache.moore;

import de.learnlib.filter.cache.InterningMembershipOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link InterningMembershipOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.cache.InterningMembershipOracle"
)
public class InterningMooreMembershipOracle<I, O> extends InterningMembershipOracle<I, Word<O>> implements MembershipOracle.MooreMembershipOracle<I, O> {
    /**
     * Delegates to {@link InterningMembershipOracle#public void <init>(MembershipOracle)}.
     * @param delegate maps to the {@code delegate} parameter of the delegate
     */
    public InterningMooreMembershipOracle(MembershipOracle.MooreMembershipOracle<I, O> delegate) {
        super(delegate);
    }
}
