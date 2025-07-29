package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.AutomatonOracle;
import de.learnlib.oracle.InclusionOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link AbstractBFInclusionOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.AbstractBFInclusionOracle"
)
public class DFABFInclusionOracle<I> extends AbstractBFInclusionOracle<DFA<?, I>, I, Boolean> implements InclusionOracle.DFAInclusionOracle<I>, AutomatonOracle.DFAOracle<I> {
    /**
     * Delegates to {@link AbstractBFInclusionOracle#public void <init>(MembershipOracle, double)}.
     * @param membershipOracle maps to the {@code membershipOracle} parameter of the delegate
     * @param multiplier maps to the {@code multiplier} parameter of the delegate
     */
    public DFABFInclusionOracle(MembershipOracle.DFAMembershipOracle<I> membershipOracle,
            double multiplier) {
        super(membershipOracle, multiplier);
    }
}
