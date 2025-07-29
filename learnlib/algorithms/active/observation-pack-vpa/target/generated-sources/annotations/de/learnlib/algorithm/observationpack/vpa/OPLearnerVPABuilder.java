package de.learnlib.algorithm.observationpack.vpa;

import de.learnlib.acex.AcexAnalyzer;
import de.learnlib.oracle.MembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.alphabet.VPAlphabet;

/**
 * A builder for constructing {@link OPLearnerVPA} instances.
 * @param <I> input symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.observationpack.vpa.OPLearnerVPA"
)
public final class OPLearnerVPABuilder<I> {
    private VPAlphabet<I> alphabet;

    private MembershipOracle.DFAMembershipOracle<I> oracle;

    private AcexAnalyzer analyzer;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public OPLearnerVPABuilder() {
        this.analyzer = de.learnlib.algorithm.observationpack.vpa.AbstractVPALearner.BuilderDefaults.analyzer();
    }

    /**
     * Returns the current value for the parameter {@code alphabet}.
     * @return the current value for the parameter {@code alphabet}
     */
    public VPAlphabet<I> getAlphabet() {
        return this.alphabet;
    }

    /**
     * Sets the new value for the parameter {@code alphabet}.
     * @param alphabet the new value for the parameter {@code alphabet}
     */
    public void setAlphabet(VPAlphabet<I> alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Sets the new value for the parameter {@code alphabet} and returns {@code this} builder instance.
     * @param alphabet the new value for the parameter {@code alphabet}
     * @return the current builder instance
     */
    public OPLearnerVPABuilder<I> withAlphabet(VPAlphabet<I> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code oracle}.
     * @return the current value for the parameter {@code oracle}
     */
    public MembershipOracle.DFAMembershipOracle<I> getOracle() {
        return this.oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle}.
     * @param oracle the new value for the parameter {@code oracle}
     */
    public void setOracle(MembershipOracle.DFAMembershipOracle<I> oracle) {
        this.oracle = oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle} and returns {@code this} builder instance.
     * @param oracle the new value for the parameter {@code oracle}
     * @return the current builder instance
     */
    public OPLearnerVPABuilder<I> withOracle(MembershipOracle.DFAMembershipOracle<I> oracle) {
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
    public OPLearnerVPABuilder<I> withAnalyzer(AcexAnalyzer analyzer) {
        this.analyzer = analyzer;
        return this;
    }

    /**
     * Creates a new {@link OPLearnerVPA} instance with the configured parameters.
     * @return the created instance
     */
    public OPLearnerVPA<I> create() {
        return new OPLearnerVPA<I>(alphabet, oracle, analyzer);
    }
}
