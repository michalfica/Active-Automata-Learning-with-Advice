package de.learnlib.filter.statistic.learner;

import de.learnlib.algorithm.LearningAlgorithm;
import de.learnlib.statistic.StatisticLearner;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.automaton.fsa.DFA;

/**
 * A type-specific refinement of {@link RefinementCounterLearner}.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.learner.RefinementCounterLearner"
)
public class DFARefinementCounterLearner<I> extends RefinementCounterLearner<DFA<?, I>, I, Boolean> implements StatisticLearner.DFAStatisticLearner<I> {
    /**
     * Delegates to {@link RefinementCounterLearner#public void <init>(LearningAlgorithm)}.
     * @param learningAlgorithm maps to the {@code learningAlgorithm} parameter of the delegate
     */
    public DFARefinementCounterLearner(LearningAlgorithm.DFALearner<I> learningAlgorithm) {
        super(learningAlgorithm);
    }
}
