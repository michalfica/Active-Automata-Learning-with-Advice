package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link CompleteExplorationEQOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.CompleteExplorationEQOracle"
)
public class MealyCompleteExplorationEQOracle<I, O> extends CompleteExplorationEQOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MealyEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link CompleteExplorationEQOracle#public void <init>(MembershipOracle, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     */
    public MealyCompleteExplorationEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int maxDepth) {
        super(sulOracle, maxDepth);
    }

    /**
     * Delegates to {@link CompleteExplorationEQOracle#public void <init>(MembershipOracle, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minDepth maps to the {@code minDepth} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     */
    public MealyCompleteExplorationEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int minDepth, int maxDepth) {
        super(sulOracle, minDepth, maxDepth);
    }

    /**
     * Delegates to {@link CompleteExplorationEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minDepth maps to the {@code minDepth} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public MealyCompleteExplorationEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int minDepth, int maxDepth, int batchSize) {
        super(sulOracle, minDepth, maxDepth, batchSize);
    }
}
