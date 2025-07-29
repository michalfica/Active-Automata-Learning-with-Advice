package de.learnlib.algorithm.observationpack.dfa;

import de.learnlib.counterexample.LocalSuffixFinder;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.lang.Boolean;
import net.automatalib.alphabet.Alphabet;

/**
 * A builder for constructing {@link OPLearnerDFA} instances.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.observationpack.dfa.OPLearnerDFA"
)
public final class OPLearnerDFABuilder<I> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Boolean> oracle;

    private LocalSuffixFinder<? super I, ? super Boolean> suffixFinder;

    private boolean repeatedCounterexampleEvaluation;

    private boolean epsilonRoot;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public OPLearnerDFABuilder() {
        this.suffixFinder = de.learnlib.algorithm.observationpack.dfa.OPLearnerDFA.BuilderDefaults.suffixFinder();
        this.repeatedCounterexampleEvaluation = de.learnlib.algorithm.observationpack.dfa.OPLearnerDFA.BuilderDefaults.repeatedCounterexampleEvaluation();
        this.epsilonRoot = de.learnlib.algorithm.observationpack.dfa.OPLearnerDFA.BuilderDefaults.epsilonRoot();
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
    public OPLearnerDFABuilder<I> withAlphabet(Alphabet<I> alphabet) {
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
    public OPLearnerDFABuilder<I> withOracle(MembershipOracle<I, Boolean> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code suffixFinder}.
     * @return the current value for the parameter {@code suffixFinder}
     */
    public LocalSuffixFinder<? super I, ? super Boolean> getSuffixFinder() {
        return this.suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder}.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     */
    public void setSuffixFinder(LocalSuffixFinder<? super I, ? super Boolean> suffixFinder) {
        this.suffixFinder = suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder} and returns {@code this} builder instance.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     * @return the current builder instance
     */
    public OPLearnerDFABuilder<I> withSuffixFinder(
            LocalSuffixFinder<? super I, ? super Boolean> suffixFinder) {
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
    public OPLearnerDFABuilder<I> withRepeatedCounterexampleEvaluation(
            boolean repeatedCounterexampleEvaluation) {
        this.repeatedCounterexampleEvaluation = repeatedCounterexampleEvaluation;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code epsilonRoot}.
     * @return the current value for the parameter {@code epsilonRoot}
     */
    public boolean getEpsilonRoot() {
        return this.epsilonRoot;
    }

    /**
     * Sets the new value for the parameter {@code epsilonRoot}.
     * @param epsilonRoot the new value for the parameter {@code epsilonRoot}
     */
    public void setEpsilonRoot(boolean epsilonRoot) {
        this.epsilonRoot = epsilonRoot;
    }

    /**
     * Sets the new value for the parameter {@code epsilonRoot} and returns {@code this} builder instance.
     * @param epsilonRoot the new value for the parameter {@code epsilonRoot}
     * @return the current builder instance
     */
    public OPLearnerDFABuilder<I> withEpsilonRoot(boolean epsilonRoot) {
        this.epsilonRoot = epsilonRoot;
        return this;
    }

    /**
     * Creates a new {@link OPLearnerDFA} instance with the configured parameters.
     * @return the created instance
     */
    public OPLearnerDFA<I> create() {
        return new OPLearnerDFA<I>(alphabet, oracle, suffixFinder, repeatedCounterexampleEvaluation, epsilonRoot);
    }
}
