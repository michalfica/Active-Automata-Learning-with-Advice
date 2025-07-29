package de.learnlib.filter.statistic.learner;

import de.learnlib.algorithm.LearningAlgorithm;
import de.learnlib.statistic.StatisticLearner;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link RefinementCounterLearner}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.filter.statistic.learner.RefinementCounterLearner"
)
public class MealyRefinementCounterLearner<I, O> extends RefinementCounterLearner<MealyMachine<?, I, ?, O>, I, Word<O>> implements StatisticLearner.MealyStatisticLearner<I, O> {
    /**
     * Delegates to {@link RefinementCounterLearner#public void <init>(LearningAlgorithm)}.
     * @param learningAlgorithm maps to the {@code learningAlgorithm} parameter of the delegate
     */
    public MealyRefinementCounterLearner(LearningAlgorithm.MealyLearner<I, O> learningAlgorithm) {
        super(learningAlgorithm);
    }
}
