package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.util.Random;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link RandomWordsEQOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.RandomWordsEQOracle"
)
public class DFARandomWordsEQOracle<I> extends RandomWordsEQOracle<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link RandomWordsEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param mqOracle maps to the {@code mqOracle} parameter of the delegate
     * @param minLength maps to the {@code minLength} parameter of the delegate
     * @param maxLength maps to the {@code maxLength} parameter of the delegate
     * @param maxTests maps to the {@code maxTests} parameter of the delegate
     */
    public DFARandomWordsEQOracle(MembershipOracle.DFAMembershipOracle<I> mqOracle, int minLength,
            int maxLength, int maxTests) {
        super(mqOracle, minLength, maxLength, maxTests);
    }

    /**
     * Delegates to {@link RandomWordsEQOracle#public void <init>(MembershipOracle, int, int, int, Random)}.
     * @param mqOracle maps to the {@code mqOracle} parameter of the delegate
     * @param minLength maps to the {@code minLength} parameter of the delegate
     * @param maxLength maps to the {@code maxLength} parameter of the delegate
     * @param maxTests maps to the {@code maxTests} parameter of the delegate
     * @param random maps to the {@code random} parameter of the delegate
     */
    public DFARandomWordsEQOracle(MembershipOracle.DFAMembershipOracle<I> mqOracle, int minLength,
            int maxLength, int maxTests, Random random) {
        super(mqOracle, minLength, maxLength, maxTests, random);
    }

    /**
     * Delegates to {@link RandomWordsEQOracle#public void <init>(MembershipOracle, int, int, int, Random, int)}.
     * @param mqOracle maps to the {@code mqOracle} parameter of the delegate
     * @param minLength maps to the {@code minLength} parameter of the delegate
     * @param maxLength maps to the {@code maxLength} parameter of the delegate
     * @param maxTests maps to the {@code maxTests} parameter of the delegate
     * @param random maps to the {@code random} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public DFARandomWordsEQOracle(MembershipOracle.DFAMembershipOracle<I> mqOracle, int minLength,
            int maxLength, int maxTests, Random random, int batchSize) {
        super(mqOracle, minLength, maxLength, maxTests, random, batchSize);
    }
}
