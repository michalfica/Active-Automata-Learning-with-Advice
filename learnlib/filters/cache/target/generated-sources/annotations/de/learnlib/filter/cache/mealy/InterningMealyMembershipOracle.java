package de.learnlib.filter.cache.mealy;

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
public class InterningMealyMembershipOracle<I, O> extends InterningMembershipOracle<I, Word<O>> implements MembershipOracle.MealyMembershipOracle<I, O> {
    /**
     * Delegates to {@link InterningMembershipOracle#public void <init>(MembershipOracle)}.
     * @param delegate maps to the {@code delegate} parameter of the delegate
     */
    public InterningMealyMembershipOracle(MembershipOracle.MealyMembershipOracle<I, O> delegate) {
        super(delegate);
    }
}
