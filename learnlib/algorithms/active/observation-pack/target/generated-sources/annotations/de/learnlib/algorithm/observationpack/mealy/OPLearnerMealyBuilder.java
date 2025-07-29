package de.learnlib.algorithm.observationpack.mealy;

import de.learnlib.counterexample.LocalSuffixFinder;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link OPLearnerMealy} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.observationpack.mealy.OPLearnerMealy"
)
public final class OPLearnerMealyBuilder<I, O> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Word<O>> oracle;

    private LocalSuffixFinder<? super I, ? super Word<O>> suffixFinder;

    private boolean repeatedCounterexampleEvaluation;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public OPLearnerMealyBuilder() {
        this.suffixFinder = de.learnlib.algorithm.observationpack.AbstractOPLearner.BuilderDefaults.suffixFinder();
        this.repeatedCounterexampleEvaluation = de.learnlib.algorithm.observationpack.AbstractOPLearner.BuilderDefaults.repeatedCounterexampleEvaluation();
    }

    /**
     * Returns the current value for the parameter {@code alphabet}.
     * @return the current value for the parameter {@code alphabet}
     */
    public Alphabet<I> getAlphabet() {
        return this.alphabet;
    }

    /**
     * Sets the new value for the parameter {@code alphabet}.
     * @param alphabet the new value for the parameter {@code alphabet}
     */
    public void setAlphabet(Alphabet<I> alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Sets the new value for the parameter {@code alphabet} and returns {@code this} builder instance.
     * @param alphabet the new value for the parameter {@code alphabet}
     * @return the current builder instance
     */
    public OPLearnerMealyBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code oracle}.
     * @return the current value for the parameter {@code oracle}
     */
    public MembershipOracle<I, Word<O>> getOracle() {
        return this.oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle}.
     * @param oracle the new value for the parameter {@code oracle}
     */
    public void setOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle} and returns {@code this} builder instance.
     * @param oracle the new value for the parameter {@code oracle}
     * @return the current builder instance
     */
    public OPLearnerMealyBuilder<I, O> withOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code suffixFinder}.
     * @return the current value for the parameter {@code suffixFinder}
     */
    public LocalSuffixFinder<? super I, ? super Word<O>> getSuffixFinder() {
        return this.suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder}.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     */
    public void setSuffixFinder(LocalSuffixFinder<? super I, ? super Word<O>> suffixFinder) {
        this.suffixFinder = suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder} and returns {@code this} builder instance.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     * @return the current builder instance
     */
    public OPLearnerMealyBuilder<I, O> withSuffixFinder(
            LocalSuffixFinder<? super I, ? super Word<O>> suffixFinder) {
        this.suffixFinder = suffixFinder;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code repeatedCounterexampleEvaluation}.
     * @return the current value for the parameter {@code repeatedCounterexampleEvaluation}
     */
    public boolean getRepeatedCounterexampleEvaluation() {
        return this.repeatedCounterexampleEvaluation;
    }

    /**
     * Sets the new value for the parameter {@code repeatedCounterexampleEvaluation}.
     * @param repeatedCounterexampleEvaluation the new value for the parameter {@code repeatedCounterexampleEvaluation}
     */
    public void setRepeatedCounterexampleEvaluation(boolean repeatedCounterexampleEvaluation) {
        this.repeatedCounterexampleEvaluation = repeatedCounterexampleEvaluation;
    }

    /**
     * Sets the new value for the parameter {@code repeatedCounterexampleEvaluation} and returns {@code this} builder instance.
     * @param repeatedCounterexampleEvaluation the new value for the parameter {@code repeatedCounterexampleEvaluation}
     * @return the current builder instance
     */
    public OPLearnerMealyBuilder<I, O> withRepeatedCounterexampleEvaluation(
            boolean repeatedCounterexampleEvaluation) {
        this.repeatedCounterexampleEvaluation = repeatedCounterexampleEvaluation;
        return this;
    }

    /**
     * Creates a new {@link OPLearnerMealy} instance with the configured parameters.
     * @return the created instance
     */
    public OPLearnerMealy<I, O> create() {
        return new OPLearnerMealy<I, O>(alphabet, oracle, suffixFinder, repeatedCounterexampleEvaluation);
    }
}
