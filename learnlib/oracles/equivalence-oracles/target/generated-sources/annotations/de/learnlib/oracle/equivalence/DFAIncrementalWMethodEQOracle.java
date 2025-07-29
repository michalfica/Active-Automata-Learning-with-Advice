package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link IncrementalWMethodEQOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.IncrementalWMethodEQOracle"
)
public class DFAIncrementalWMethodEQOracle<I> extends IncrementalWMethodEQOracle<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link IncrementalWMethodEQOracle#public void <init>(MembershipOracle, Alphabet)}.
     * @param oracle maps to the {@code oracle} parameter of the delegate
     * @param alphabet maps to the {@code alphabet} parameter of the delegate
     */
    public DFAIncrementalWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> oracle,
            Alphabet<I> alphabet) {
        super(oracle, alphabet);
    }

    /**
     * Delegates to {@link IncrementalWMethodEQOracle#public void <init>(MembershipOracle, Alphabet, int)}.
     * @param oracle maps to the {@code oracle} parameter of the delegate
     * @param alphabet maps to the {@code alphabet} parameter of the delegate
     * @param maxDepth maps to the {@code maxDepth} parameter of the delegate
     */
    public DFAIncrementalWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> oracle,
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
    public DFAIncrementalWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> oracle,
            Alphabet<I> alphabet, int maxDepth, int batchSize) {
        super(oracle, alphabet, maxDepth, batchSize);
    }
}
