package de.learnlib.oracle.emptiness;

import de.learnlib.oracle.AutomatonOracle;
import de.learnlib.oracle.EmptinessOracle;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link AbstractBFEmptinessOracle}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.emptiness.AbstractBFEmptinessOracle"
)
public class DFABFEmptinessOracle<I> extends AbstractBFEmptinessOracle<DFA<?, I>, I, Boolean> implements EmptinessOracle.DFAEmptinessOracle<I>, AutomatonOracle.DFAOracle<I> {
    /**
     * Delegates to {@link AbstractBFEmptinessOracle#protected void <init>(MembershipOracle, double)}.
     * @param membershipOracle maps to the {@code membershipOracle} parameter of the delegate
     * @param multiplier maps to the {@code multiplier} parameter of the delegate
     */
    public DFABFEmptinessOracle(MembershipOracle.DFAMembershipOracle<I> membershipOracle,
            double multiplier) {
        super(membershipOracle, multiplier);
    }
}
