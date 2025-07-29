package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.AutomatonOracle;
import de.learnlib.oracle.InclusionOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link AbstractBFInclusionOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.AbstractBFInclusionOracle"
)
public class MealyBFInclusionOracle<I, O> extends AbstractBFInclusionOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements InclusionOracle.MealyInclusionOracle<I, O>, AutomatonOracle.MealyOracle<I, O> {
    /**
     * Delegates to {@link AbstractBFInclusionOracle#public void <init>(MembershipOracle, double)}.
     * @param membershipOracle maps to the {@code membershipOracle} parameter of the delegate
     * @param multiplier maps to the {@code multiplier} parameter of the delegate
     */
    public MealyBFInclusionOracle(MembershipOracle.MealyMembershipOracle<I, O> membershipOracle,
            double multiplier) {
        super(membershipOracle, multiplier);
    }
}
