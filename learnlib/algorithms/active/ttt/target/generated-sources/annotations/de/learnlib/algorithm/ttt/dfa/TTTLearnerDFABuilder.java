package de.learnlib.algorithm.ttt.dfa;

import de.learnlib.acex.AcexAnalyzer;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.alphabet.Alphabet;

/**
 * A builder for constructing {@link TTTLearnerDFA} instances.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.ttt.dfa.TTTLearnerDFA"
)
public final class TTTLearnerDFABuilder<I> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Boolean> oracle;

    private AcexAnalyzer analyzer;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public TTTLearnerDFABuilder() {
        this.analyzer = de.learnlib.algorithm.ttt.base.AbstractTTTLearner.BuilderDefaults.analyzer();
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
    public TTTLearnerDFABuilder<I> withAlphabet(Alphabet<I> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code oracle}.
     * @return the current value for the parameter {@code oracle}
     */
    public MembershipOracle<I, Boolean> getOracle() {
        return this.oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle}.
     * @param oracle the new value for the parameter {@code oracle}
     */
    public void setOracle(MembershipOracle<I, Boolean> oracle) {
        this.oracle = oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle} and returns {@code this} builder instance.
     * @param oracle the new value for the parameter {@code oracle}
     * @return the current builder instance
     */
    public TTTLearnerDFABuilder<I> withOracle(MembershipOracle<I, Boolean> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code analyzer}.
     * @return the current value for the parameter {@code analyzer}
     */
    public AcexAnalyzer getAnalyzer() {
        return this.analyzer;
    }

    /**
     * Sets the new value for the parameter {@code analyzer}.
     * @param analyzer the new value for the parameter {@code analyzer}
     */
    public void setAnalyzer(AcexAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Sets the new value for the parameter {@code analyzer} and returns {@code this} builder instance.
     * @param analyzer the new value for the parameter {@code analyzer}
     * @return the current builder instance
     */
    public TTTLearnerDFABuilder<I> withAnalyzer(AcexAnalyzer analyzer) {
        this.analyzer = analyzer;
        return this;
    }

    /**
     * Creates a new {@link TTTLearnerDFA} instance with the configured parameters.
     * @return the created instance
     */
    public TTTLearnerDFA<I> create() {
        return new TTTLearnerDFA<I>(alphabet, oracle, analyzer);
    }
}
