package de.learnlib.oracle.emptiness;

import de.learnlib.oracle.AutomatonOracle;
import de.learnlib.oracle.EmptinessOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link AbstractBFEmptinessOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.emptiness.AbstractBFEmptinessOracle"
)
public class MealyBFEmptinessOracle<I, O> extends AbstractBFEmptinessOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements EmptinessOracle.MealyEmptinessOracle<I, O>, AutomatonOracle.MealyOracle<I, O> {
    /**
     * Delegates to {@link AbstractBFEmptinessOracle#protected void <init>(MembershipOracle, double)}.
     * @param membershipOracle maps to the {@code membershipOracle} parameter of the delegate
     * @param multiplier maps to the {@code multiplier} parameter of the delegate
     */
    public MealyBFEmptinessOracle(MembershipOracle.MealyMembershipOracle<I, O> membershipOracle,
            double multiplier) {
        super(membershipOracle, multiplier);
    }
}
