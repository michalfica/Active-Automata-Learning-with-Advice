package de.learnlib.algorithm.dhc.mealy;

import de.learnlib.counterexample.GlobalSuffixFinder;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.Collection;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link MealyDHC} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.dhc.mealy.MealyDHC"
)
public final class MealyDHCBuilder<I, O> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Word<O>> oracle;

    private GlobalSuffixFinder<? super I, ? super Word<O>> suffixFinder;

    private Collection<? extends Word<I>> initialSplitters;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public MealyDHCBuilder() {
        this.suffixFinder = de.learnlib.algorithm.dhc.mealy.MealyDHC.BuilderDefaults.suffixFinder();
        this.initialSplitters = de.learnlib.algorithm.dhc.mealy.MealyDHC.BuilderDefaults.initialSplitters();
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
    public MealyDHCBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
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
    public MealyDHCBuilder<I, O> withOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code suffixFinder}.
     * @return the current value for the parameter {@code suffixFinder}
     */
    public GlobalSuffixFinder<? super I, ? super Word<O>> getSuffixFinder() {
        return this.suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder}.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     */
    public void setSuffixFinder(GlobalSuffixFinder<? super I, ? super Word<O>> suffixFinder) {
        this.suffixFinder = suffixFinder;
    }

    /**
     * Sets the new value for the parameter {@code suffixFinder} and returns {@code this} builder instance.
     * @param suffixFinder the new value for the parameter {@code suffixFinder}
     * @return the current builder instance
     */
    public MealyDHCBuilder<I, O> withSuffixFinder(
            GlobalSuffixFinder<? super I, ? super Word<O>> suffixFinder) {
        this.suffixFinder = suffixFinder;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code initialSplitters}.
     * @return the current value for the parameter {@code initialSplitters}
     */
    public Collection<? extends Word<I>> getInitialSplitters() {
        return this.initialSplitters;
    }

    /**
     * Sets the new value for the parameter {@code initialSplitters}.
     * @param initialSplitters the new value for the parameter {@code initialSplitters}
     */
    public void setInitialSplitters(Collection<? extends Word<I>> initialSplitters) {
        this.initialSplitters = initialSplitters;
    }

    /**
     * Sets the new value for the parameter {@code initialSplitters} and returns {@code this} builder instance.
     * @param initialSplitters the new value for the parameter {@code initialSplitters}
     * @return the current builder instance
     */
    public MealyDHCBuilder<I, O> withInitialSplitters(
            Collection<? extends Word<I>> initialSplitters) {
        this.initialSplitters = initialSplitters;
        return this;
    }

    /**
     * Creates a new {@link MealyDHC} instance with the configured parameters.
     * @return the created instance
     */
    public MealyDHC<I, O> create() {
        return new MealyDHC<I, O>(alphabet, oracle, suffixFinder, initialSplitters);
    }
}
