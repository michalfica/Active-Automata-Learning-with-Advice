package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import java.util.Random;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link RandomWpMethodEQOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.RandomWpMethodEQOracle"
)
public class DFARandomWpMethodEQOracle<I> extends RandomWpMethodEQOracle<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link RandomWpMethodEQOracle#public void <init>(MembershipOracle, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minimalSize maps to the {@code minimalSize} parameter of the delegate
     * @param rndLength maps to the {@code rndLength} parameter of the delegate
     */
    public DFARandomWpMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle,
            int minimalSize, int rndLength) {
        super(sulOracle, minimalSize, rndLength);
    }

    /**
     * Delegates to {@link RandomWpMethodEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minimalSize maps to the {@code minimalSize} parameter of the delegate
     * @param rndLength maps to the {@code rndLength} parameter of the delegate
     * @param bound maps to the {@code bound} parameter of the delegate
     */
    public DFARandomWpMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle,
            int minimalSize, int rndLength, int bound) {
        super(sulOracle, minimalSize, rndLength, bound);
    }

    /**
     * Delegates to {@link RandomWpMethodEQOracle#public void <init>(MembershipOracle, int, int, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minimalSize maps to the {@code minimalSize} parameter of the delegate
     * @param rndLength maps to the {@code rndLength} parameter of the delegate
     * @param bound maps to the {@code bound} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public DFARandomWpMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle,
            int minimalSize, int rndLength, int bound, int batchSize) {
        super(sulOracle, minimalSize, rndLength, bound, batchSize);
    }

    /**
     * Delegates to {@link RandomWpMethodEQOracle#public void <init>(MembershipOracle, int, int, int, Random, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param minimalSize maps to the {@code minimalSize} parameter of the delegate
     * @param rndLength maps to the {@code rndLength} parameter of the delegate
     * @param bound maps to the {@code bound} parameter of the delegate
     * @param random maps to the {@code random} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public DFARandomWpMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle,
            int minimalSize, int rndLength, int bound, Random random, int batchSize) {
        super(sulOracle, minimalSize, rndLength, bound, random, batchSize);
    }
}
