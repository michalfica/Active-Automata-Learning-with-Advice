package de.learnlib.algorithm.kv.mealy;

import de.learnlib.acex.AcexAnalyzer;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link KearnsVaziraniMealy} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.kv.mealy.KearnsVaziraniMealy"
)
public final class KearnsVaziraniMealyBuilder<I, O> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Word<O>> oracle;

    private boolean repeatedCounterexampleEvaluation;

    private AcexAnalyzer counterexampleAnalyzer;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public KearnsVaziraniMealyBuilder() {
        this.repeatedCounterexampleEvaluation = de.learnlib.algorithm.kv.mealy.KearnsVaziraniMealy.BuilderDefaults.repeatedCounterexampleEvaluation();
        this.counterexampleAnalyzer = de.learnlib.algorithm.kv.mealy.KearnsVaziraniMealy.BuilderDefaults.counterexampleAnalyzer();
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
    public KearnsVaziraniMealyBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
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
    public KearnsVaziraniMealyBuilder<I, O> withOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
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
    public KearnsVaziraniMealyBuilder<I, O> withRepeatedCounterexampleEvaluation(
            boolean repeatedCounterexampleEvaluation) {
        this.repeatedCounterexampleEvaluation = repeatedCounterexampleEvaluation;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code counterexampleAnalyzer}.
     * @return the current value for the parameter {@code counterexampleAnalyzer}
     */
    public AcexAnalyzer getCounterexampleAnalyzer() {
        return this.counterexampleAnalyzer;
    }

    /**
     * Sets the new value for the parameter {@code counterexampleAnalyzer}.
     * @param counterexampleAnalyzer the new value for the parameter {@code counterexampleAnalyzer}
     */
    public void setCounterexampleAnalyzer(AcexAnalyzer counterexampleAnalyzer) {
        this.counterexampleAnalyzer = counterexampleAnalyzer;
    }

    /**
     * Sets the new value for the parameter {@code counterexampleAnalyzer} and returns {@code this} builder instance.
     * @param counterexampleAnalyzer the new value for the parameter {@code counterexampleAnalyzer}
     * @return the current builder instance
     */
    public KearnsVaziraniMealyBuilder<I, O> withCounterexampleAnalyzer(
            AcexAnalyzer counterexampleAnalyzer) {
        this.counterexampleAnalyzer = counterexampleAnalyzer;
        return this;
    }

    /**
     * Creates a new {@link KearnsVaziraniMealy} instance with the configured parameters.
     * @return the created instance
     */
    public KearnsVaziraniMealy<I, O> create() {
        return new KearnsVaziraniMealy<I, O>(alphabet, oracle, repeatedCounterexampleEvaluation, counterexampleAnalyzer);
    }
}
