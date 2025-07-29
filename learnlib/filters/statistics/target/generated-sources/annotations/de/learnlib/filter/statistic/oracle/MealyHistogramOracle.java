package de.learnlib.filter.statistic.oracle;

import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.String;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link HistogramOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.oracle.HistogramOracle"
)
public class MealyHistogramOracle<I, O> extends HistogramOracle<I, Word<O>> implements MembershipOracle.MealyMembershipOracle<I, O> {
    /**
     * Delegates to {@link HistogramOracle#public void <init>(MembershipOracle, String)}.
     * @param next maps to the {@code next} parameter of the delegate
     * @param name maps to the {@code name} parameter of the delegate
     */
    public MealyHistogramOracle(MembershipOracle.MealyMembershipOracle<I, O> next, String name) {
        super(next, name);
    }
}
