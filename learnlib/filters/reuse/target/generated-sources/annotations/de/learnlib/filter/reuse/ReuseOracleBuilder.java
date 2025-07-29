package de.learnlib.filter.reuse;

import de.learnlib.filter.reuse.tree.BoundedDeque;
import de.learnlib.filter.reuse.tree.SystemStateHandler;
import de.learnlib.tooling.annotation.Generated;
import java.util.Set;
import java.util.function.Supplier;
import net.automatalib.alphabet.Alphabet;

/**
 * A builder for constructing {@link ReuseOracle} instances.
 * @param <S> system state type
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.filter.reuse.ReuseOracle"
)
public final class ReuseOracleBuilder<S, I, O> {
    private Alphabet<I> alphabet;

    private Supplier<? extends ReuseCapableOracle<S, I, O>> oracleSupplier;

    private boolean enabledSystemStateInvalidation;

    private SystemStateHandler<S> systemStateHandler;

    private Set<I> invariantInputs;

    private Set<O> failureOutputs;

    private int maxSystemStates;

    private BoundedDeque.AccessPolicy accessPolicy;

    private BoundedDeque.EvictPolicy evictPolicy;

    /**
     * Creates a new builder (and may set default values for some parameters).
     * @param alphabet the value used to initialize parameter {@code alphabet}
     * @param oracleSupplier the value used to initialize parameter {@code oracleSupplier}
     */
    public ReuseOracleBuilder(Alphabet<I> alphabet,
            Supplier<? extends ReuseCapableOracle<S, I, O>> oracleSupplier) {
        this.alphabet = alphabet;
        this.oracleSupplier = oracleSupplier;
        this.enabledSystemStateInvalidation = de.learnlib.filter.reuse.BuilderDefaults.enabledSystemStateInvalidation();
        this.systemStateHandler = de.learnlib.filter.reuse.BuilderDefaults.systemStateHandler();
        this.invariantInputs = de.learnlib.filter.reuse.BuilderDefaults.invariantInputs();
        this.failureOutputs = de.learnlib.filter.reuse.BuilderDefaults.failureOutputs();
        this.maxSystemStates = de.learnlib.filter.reuse.BuilderDefaults.maxSystemStates();
        this.accessPolicy = de.learnlib.filter.reuse.BuilderDefaults.accessPolicy();
        this.evictPolicy = de.learnlib.filter.reuse.BuilderDefaults.evictPolicy();
    }

    /**
     * Sets the new value for the parameter {@code alphabet} and returns {@code this} builder instance.
     * @param alphabet the new value for the parameter {@code alphabet}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withAlphabet(Alphabet<I> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code oracleSupplier} and returns {@code this} builder instance.
     * @param oracleSupplier the new value for the parameter {@code oracleSupplier}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withOracleSupplier(
            Supplier<? extends ReuseCapableOracle<S, I, O>> oracleSupplier) {
        this.oracleSupplier = oracleSupplier;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code enabledSystemStateInvalidation} and returns {@code this} builder instance.
     * @param enabledSystemStateInvalidation the new value for the parameter {@code enabledSystemStateInvalidation}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withEnabledSystemStateInvalidation(
            boolean enabledSystemStateInvalidation) {
        this.enabledSystemStateInvalidation = enabledSystemStateInvalidation;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code systemStateHandler} and returns {@code this} builder instance.
     * @param systemStateHandler the new value for the parameter {@code systemStateHandler}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withSystemStateHandler(
            SystemStateHandler<S> systemStateHandler) {
        this.systemStateHandler = systemStateHandler;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code invariantInputs} and returns {@code this} builder instance.
     * @param invariantInputs the new value for the parameter {@code invariantInputs}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withInvariantInputs(Set<I> invariantInputs) {
        this.invariantInputs = invariantInputs;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code failureOutputs} and returns {@code this} builder instance.
     * @param failureOutputs the new value for the parameter {@code failureOutputs}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withFailureOutputs(Set<O> failureOutputs) {
        this.failureOutputs = failureOutputs;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code maxSystemStates} and returns {@code this} builder instance.
     * @param maxSystemStates the new value for the parameter {@code maxSystemStates}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withMaxSystemStates(int maxSystemStates) {
        this.maxSystemStates = maxSystemStates;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code accessPolicy} and returns {@code this} builder instance.
     * @param accessPolicy the new value for the parameter {@code accessPolicy}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withAccessPolicy(BoundedDeque.AccessPolicy accessPolicy) {
        this.accessPolicy = accessPolicy;
        return this;
    }

    /**
     * Sets the new value for the parameter {@code evictPolicy} and returns {@code this} builder instance.
     * @param evictPolicy the new value for the parameter {@code evictPolicy}
     * @return the current builder instance
     */
    public ReuseOracleBuilder<S, I, O> withEvictPolicy(BoundedDeque.EvictPolicy evictPolicy) {
        this.evictPolicy = evictPolicy;
        return this;
    }

    /**
     * Creates a new {@link ReuseOracle} instance with the configured parameters.
     * @return the created instance
     */
    public ReuseOracle<S, I, O> build() {
        return new ReuseOracle<S, I, O>(alphabet, oracleSupplier, enabledSystemStateInvalidation, systemStateHandler, invariantInputs, failureOutputs, maxSystemStates, accessPolicy, evictPolicy);
    }
}
