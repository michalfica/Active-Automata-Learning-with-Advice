package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link IncrementalWMethodEQOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.IncrementalWMethodEQOracle"
)
public class MealyIncrementalWMethodEQOracle<I, O> extends IncrementalWMethodEQOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MealyEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link IncrementalWMethodEQOracle#public void <init>(MembershipOracle, Alphabet)}.
     * @param oracle maps to the {@code oracle} parameter of the delegate
     * @param alphabet maps to the {@code alphabet} parameter of the delegate
     */
    public MealyIncrementalWMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> oracle,
            Alphabet<I> alphabet) {
        super(oracle, alphabet);
    }

    /**
     * Delegates to {@link IncrementalWMethodEQOracle#public void <init>(MembershipOracle, Alphabet, int)}.
     * @param oracle maps to the {@code oracle} parameter of the delegate
     * @param alphabet maps to the {@code alphabet} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     */
    public MealyIncrementalWMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> oracle,
            Alphabet<I> alphabet, int maxDepth) {
        super(oracle, alphabet, maxDepth);
    }

    /**
     * Delegates to {@link IncrementalWMethodEQOracle#public void <init>(MembershipOracle, Alphabet, int, int)}.
     * @param oracle maps to the {@code oracle} parameter of the delegate
     * @param alphabet maps to the {@code alphabet} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public MealyIncrementalWMethodEQOracle(MembershipOracle.MealyMembershipOracle<I, O> oracle,
            Alphabet<I> alphabet, int maxDepth, int batchSize) {
        super(oracle, alphabet, maxDepth, batchSize);
    }
}
