package de.learnlib.algorithm.rivestschapire;

import de.learnlib.algorithm.lstar.closing.ClosingStrategy;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.List;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link RivestSchapireMoore} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.rivestschapire.RivestSchapireMoore"
)
public final class RivestSchapireMooreBuilder<I, O> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Word<O>> oracle;

    private List<Word<I>> initialSuffixes;

    private ClosingStrategy<? super I, ? super Word<O>> closingStrategy;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public RivestSchapireMooreBuilder() {
        this.initialSuffixes = de.learnlib.algorithm.lstar.AbstractExtensibleAutomatonLStar.BuilderDefaults.initialSuffixes();
        this.closingStrategy = de.learnlib.algorithm.lstar.AbstractExtensibleAutomatonLStar.BuilderDefaults.closingStrategy();
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
    public RivestSchapireMooreBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
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
    public RivestSchapireMooreBuilder<I, O> withOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code initialSuffixes}.
     * @return the current value for the parameter {@code initialSuffixes}
     */
    public List<Word<I>> getInitialSuffixes() {
        return this.initialSuffixes;
    }

    /**
     * Sets the new value for the parameter {@code initialSuffixes}.
     * @param initialSuffixes the new value for the parameter {@code initialSuffixes}
     */
    public void setInitialSuffixes(List<Word<I>> initialSuffixes) {
        this.initialSuffixes = initialSuffixes;
    }

    /**
     * Sets the new value for the parameter {@code initialSuffixes} and returns {@code this} builder instance.
     * @param initialSuffixes the new value for the parameter {@code initialSuffixes}
     * @return the current builder instance
     */
    public RivestSchapireMooreBuilder<I, O> withInitialSuffixes(List<Word<I>> initialSuffixes) {
        this.initialSuffixes = initialSuffixes;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code closingStrategy}.
     * @return the current value for the parameter {@code closingStrategy}
     */
    public ClosingStrategy<? super I, ? super Word<O>> getClosingStrategy() {
        return this.closingStrategy;
    }

    /**
     * Sets the new value for the parameter {@code closingStrategy}.
     * @param closingStrategy the new value for the parameter {@code closingStrategy}
     */
    public void setClosingStrategy(ClosingStrategy<? super I, ? super Word<O>> closingStrategy) {
        this.closingStrategy = closingStrategy;
    }

    /**
     * Sets the new value for the parameter {@code closingStrategy} and returns {@code this} builder instance.
     * @param closingStrategy the new value for the parameter {@code closingStrategy}
     * @return the current builder instance
     */
    public RivestSchapireMooreBuilder<I, O> withClosingStrategy(
            ClosingStrategy<? super I, ? super Word<O>> closingStrategy) {
        this.closingStrategy = closingStrategy;
        return this;
    }

    /**
     * Creates a new {@link RivestSchapireMoore} instance with the configured parameters.
     * @return the created instance
     */
    public RivestSchapireMoore<I, O> create() {
        return new RivestSchapireMoore<I, O>(alphabet, oracle, initialSuffixes, closingStrategy);
    }
}
