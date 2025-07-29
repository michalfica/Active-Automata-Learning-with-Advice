package de.learnlib.algorithm.nlstar;

import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.alphabet.Alphabet;

/**
 * A builder for constructing {@link NLStarLearner} instances.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.nlstar.NLStarLearner"
)
public final class NLStarLearnerBuilder<I> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Boolean> oracle;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public NLStarLearnerBuilder() {
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
    public NLStarLearnerBuilder<I> withAlphabet(Alphabet<I> alphabet) {
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
    public NLStarLearnerBuilder<I> withOracle(MembershipOracle<I, Boolean> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Creates a new {@link NLStarLearner} instance with the configured parameters.
     * @return the created instance
     */
    public NLStarLearner<I> create() {
        return new NLStarLearner<I>(alphabet, oracle);
    }
}
