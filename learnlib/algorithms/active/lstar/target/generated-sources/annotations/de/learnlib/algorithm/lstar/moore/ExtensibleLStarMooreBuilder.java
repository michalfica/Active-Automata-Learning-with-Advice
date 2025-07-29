package de.learnlib.algorithm.lstar.moore;

import de.learnlib.algorithm.lstar.ce.ObservationTableCEXHandler;
import de.learnlib.algorithm.lstar.closing.ClosingStrategy;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.List;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link ExtensibleLStarMoore} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.lstar.moore.ExtensibleLStarMoore"
)
public final class ExtensibleLStarMooreBuilder<I, O> {
    private Alphabet<I> alphabet;

    private MembershipOracle<I, Word<O>> oracle;

    private List<Word<I>> initialPrefixes;

    private List<Word<I>> initialSuffixes;

    private ObservationTableCEXHandler<? super I, ? super Word<O>> cexHandler;

    private ClosingStrategy<? super I, ? super Word<O>> closingStrategy;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public ExtensibleLStarMooreBuilder() {
        this.initialPrefixes = de.learnlib.algorithm.lstar.AbstractExtensibleAutomatonLStar.BuilderDefaults.initialPrefixes();
        this.initialSuffixes = de.learnlib.algorithm.lstar.AbstractExtensibleAutomatonLStar.BuilderDefaults.initialSuffixes();
        this.cexHandler = de.learnlib.algorithm.lstar.AbstractExtensibleAutomatonLStar.BuilderDefaults.cexHandler();
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
    public ExtensibleLStarMooreBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
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
    public ExtensibleLStarMooreBuilder<I, O> withOracle(MembershipOracle<I, Word<O>> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code initialPrefixes}.
     * @return the current value for the parameter {@code initialPrefixes}
     */
    public List<Word<I>> getInitialPrefixes() {
        return this.initialPrefixes;
    }

    /**
     * Sets the new value for the parameter {@code initialPrefixes}.
     * @param initialPrefixes the new value for the parameter {@code initialPrefixes}
     */
    public void setInitialPrefixes(List<Word<I>> initialPrefixes) {
        this.initialPrefixes = initialPrefixes;
    }

    /**
     * Sets the new value for the parameter {@code initialPrefixes} and returns {@code this} builder instance.
     * @param initialPrefixes the new value for the parameter {@code initialPrefixes}
     * @return the current builder instance
     */
    public ExtensibleLStarMooreBuilder<I, O> withInitialPrefixes(List<Word<I>> initialPrefixes) {
        this.initialPrefixes = initialPrefixes;
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
    public ExtensibleLStarMooreBuilder<I, O> withInitialSuffixes(List<Word<I>> initialSuffixes) {
        this.initialSuffixes = initialSuffixes;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code cexHandler}.
     * @return the current value for the parameter {@code cexHandler}
     */
    public ObservationTableCEXHandler<? super I, ? super Word<O>> getCexHandler() {
        return this.cexHandler;
    }

    /**
     * Sets the new value for the parameter {@code cexHandler}.
     * @param cexHandler the new value for the parameter {@code cexHandler}
     */
    public void setCexHandler(ObservationTableCEXHandler<? super I, ? super Word<O>> cexHandler) {
        this.cexHandler = cexHandler;
    }

    /**
     * Sets the new value for the parameter {@code cexHandler} and returns {@code this} builder instance.
     * @param cexHandler the new value for the parameter {@code cexHandler}
     * @return the current builder instance
     */
    public ExtensibleLStarMooreBuilder<I, O> withCexHandler(
            ObservationTableCEXHandler<? super I, ? super Word<O>> cexHandler) {
        this.cexHandler = cexHandler;
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
    public ExtensibleLStarMooreBuilder<I, O> withClosingStrategy(
            ClosingStrategy<? super I, ? super Word<O>> closingStrategy) {
        this.closingStrategy = closingStrategy;
        return this;
    }

    /**
     * Creates a new {@link ExtensibleLStarMoore} instance with the configured parameters.
     * @return the created instance
     */
    public ExtensibleLStarMoore<I, O> create() {
        return new ExtensibleLStarMoore<I, O>(alphabet, oracle, initialPrefixes, initialSuffixes, cexHandler, closingStrategy);
    }
}
