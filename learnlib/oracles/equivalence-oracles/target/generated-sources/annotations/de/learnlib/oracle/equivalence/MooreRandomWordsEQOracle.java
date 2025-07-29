package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.Random;
import net.automatalib.automaton.transducer.MooreMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link RandomWordsEQOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.RandomWordsEQOracle"
)
public class MooreRandomWordsEQOracle<I, O> extends RandomWordsEQOracle<MooreMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MooreEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link RandomWordsEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param mqOracle maps to the {@code mqOracle} parameter of the delegate
     * @param minLength maps to the {@code minLength} parameter of the delegate
     * @param maxLength maps to the {@code maxLength} parameter of the delegate
     * @param maxTests maps to the {@code maxTests} parameter of the delegate
     */
    public MooreRandomWordsEQOracle(MembershipOracle.MooreMembershipOracle<I, O> mqOracle,
            int minLength, int maxLength, int maxTests) {
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
    public MooreRandomWordsEQOracle(MembershipOracle.MooreMembershipOracle<I, O> mqOracle,
            int minLength, int maxLength, int maxTests, Random random) {
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
    public MooreRandomWordsEQOracle(MembershipOracle.MooreMembershipOracle<I, O> mqOracle,
            int minLength, int maxLength, int maxTests, Random random, int batchSize) {
        super(mqOracle, minLength, maxLength, maxTests, random, batchSize);
    }
}
