package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link WpMethodEQOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.WpMethodEQOracle"
)
public class MealyWpMethodEQOracle<I, O> extends WpMethodEQOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MealyEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link WpMethodEQOracle#public void <init>(MembershipOracle)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     */
    public MealyWpMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle) {
        super(sulOracle);
    }

    /**
     * Delegates to {@link WpMethodEQOracle#public void <init>(MembershipOracle, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     */
    public MealyWpMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int lookahead) {
        super(sulOracle, lookahead);
    }

    /**
     * Delegates to {@link WpMethodEQOracle#public void <init>(MembershipOracle, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     * @param expectedSize maps to the {@code expectedSize} parameter of the delegate
     */
    public MealyWpMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int lookahead, int expectedSize) {
        super(sulOracle, lookahead, expectedSize);
    }

    /**
     * Delegates to {@link WpMethodEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     * @param expectedSize maps to the {@code expectedSize} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public MealyWpMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> sulOracle,
            int lookahead, int expectedSize, int batchSize) {
        super(sulOracle, lookahead, expectedSize, batchSize);
    }
}
