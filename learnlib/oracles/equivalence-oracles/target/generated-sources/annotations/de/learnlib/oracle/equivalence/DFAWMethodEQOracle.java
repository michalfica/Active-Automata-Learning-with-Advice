package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link WMethodEQOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.WMethodEQOracle"
)
public class DFAWMethodEQOracle<I> extends WMethodEQOracle<DFA<?, I>, I, Boolean> implements EquivalenceOracle.DFAEquivalenceOracle<I> {
    /**
     * Delegates to {@link WMethodEQOracle#public void <init>(MembershipOracle)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     */
    public DFAWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle) {
        super(sulOracle);
    }

    /**
     * Delegates to {@link WMethodEQOracle#public void <init>(MembershipOracle, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     */
    public DFAWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle, int lookahead) {
        super(sulOracle, lookahead);
    }

    /**
     * Delegates to {@link WMethodEQOracle#public void <init>(MembershipOracle, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     * @param expectedSize maps to the {@code expectedSize} parameter of the delegate
     */
    public DFAWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle, int lookahead,
            int expectedSize) {
        super(sulOracle, lookahead, expectedSize);
    }

    /**
     * Delegates to {@link WMethodEQOracle#public void <init>(MembershipOracle, int, int, int)}.
     * @param sulOracle maps to the {@code sulOracle} parameter of the delegate
     * @param lookahead maps to the {@code lookahead} parameter of the delegate
     * @param expectedSize maps to the {@code expectedSize} parameter of the delegate
     * @param batchSize maps to the {@code batchSize} parameter of the delegate
     */
    public DFAWMethodEQOracle(MembershipOracle.DFAMembershipOracle<I> sulOracle, int lookahead,
            int expectedSize, int batchSize) {
        super(sulOracle, lookahead, expectedSize, batchSize);
    }
}
