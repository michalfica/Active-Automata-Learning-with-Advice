package de.learnlib.algorithm.adt.learner;

import de.learnlib.algorithm.adt.api.ADTExtender;
import de.learnlib.algorithm.adt.api.LeafSplitter;
import de.learnlib.algorithm.adt.api.SubtreeReplacer;
import de.learnlib.counterexample.LocalSuffixFinder;
import de.learnlib.oracle.AdaptiveMembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link ADTLearner} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.adt.learner.ADTLearner"
)
public final class ADTLearnerBuilder<I, O> {
    private Alphabet<I> alphabet;

    private AdaptiveMembershipOracle<I, O> oracle;

    private LeafSplitter leafSplitter;

    private ADTExtender adtExtender;

    private SubtreeReplacer subtreeReplacer;

    private boolean useObservationTree;

    private LocalSuffixFinder<? super I, ? super Word<O>> suffixFinder;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public ADTLearnerBuilder() {
        this.leafSplitter = de.learnlib.algorithm.adt.learner.ADTLearner.BuilderDefaults.leafSplitter();
        this.adtExtender = de.learnlib.algorithm.adt.learner.ADTLearner.BuilderDefaults.adtExtender();
        this.subtreeReplacer = de.learnlib.algorithm.adt.learner.ADTLearner.BuilderDefaults.subtreeReplacer();
        this.useObservationTree = de.learnlib.algorithm.adt.learner.ADTLearner.BuilderDefaults.useObservationTree();
        this.suffixFinder = de.learnlib.algorithm.adt.learner.ADTLearner.BuilderDefaults.suffixFinder();
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
    public ADTLearnerBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
        this.alphabet = alphabet;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code oracle}.
     * @return the current value for the parameter {@code oracle}
     */
    public AdaptiveMembershipOracle<I, O> getOracle() {
        return this.oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle}.
     * @param oracle the new value for the parameter {@code oracle}
     */
    public void setOracle(AdaptiveMembershipOracle<I, O> oracle) {
        this.oracle = oracle;
    }

    /**
     * Sets the new value for the parameter {@code oracle} and returns {@code this} builder instance.
     * @param oracle the new value for the parameter {@code oracle}
     * @return the current builder instance
     */
    public ADTLearnerBuilder<I, O> withOracle(AdaptiveMembershipOracle<I, O> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code leafSplitter}.
     * @return the current value for the parameter {@code leafSplitter}
     */
    public LeafSplitter getLeafSplitter() {
        return this.leafSplitter;
    }

    /**
     * Sets the new value for the parameter {@code leafSplitter}.
     * @param leafSplitter the new value for the parameter {@code leafSplitter}
     */
    public void setLeafSplitter(LeafSplitter leafSplitter) {
        this.leafSplitter = leafSplitter;
    }

    /**
     * Sets the new value for the parameter {@code leafSplitter} and returns {@code this} builder instance.
     * @param leafSplitter the new value for the parameter {@code leafSplitter}
     * @return the current builder instance
     */
    public ADTLearnerBuilder<I, O> withLeafSplitter(LeafSplitter leafSplitter) {
        this.leafSplitter = leafSplitter;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code adtExtender}.
     * @return the current value for the parameter {@code adtExtender}
     */
    public ADTExtender getAdtExtender() {
        return this.adtExtender;
    }

    /**
     * Sets the new value for the parameter {@code adtExtender}.
     * @param adtExtender the new value for the parameter {@code adtExtender}
     */
    public void setAdtExtender(ADTExtender adtExtender) {
        this.adtExtender = adtExtender;
    }

    /**
     * Sets the new value for the parameter {@code adtExtender} and returns {@code this} builder instance.
     * @param adtExtender the new value for the parameter {@code adtExtender}
     * @return the current builder instance
     */
    public ADTLearnerBuilder<I, O> withAdtExtender(ADTExtender adtExtender) {
        this.adtExtender = adtExtender;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code subtreeReplacer}.
     * @return the current value for the parameter {@code subtreeReplacer}
     */
    public SubtreeReplacer getSubtreeReplacer() {
        return this.subtreeReplacer;
    }

    /**
     * Sets the new value for the parameter {@code subtreeReplacer}.
     * @param subtreeReplacer the new value for the parameter {@code subtreeReplacer}
     */
    public void setSubtreeReplacer(SubtreeReplacer subtreeReplacer) {
        this.subtreeReplacer = subtreeReplacer;
    }

    /**
     * Sets the new value for the parameter {@code subtreeReplacer} and returns {@code this} builder instance.
     * @param subtreeReplacer the new value for the parameter {@code subtreeReplacer}
     * @return the current builder instance
     */
    public ADTLearnerBuilder<I, O> withSubtreeReplacer(SubtreeReplacer subtreeReplacer) {
        this.subtreeReplacer = subtreeReplacer;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code useObservationTree}.
     * @return the current value for the parameter {@code useObservationTree}
     */
    public boolean getUseObservationTree() {
        return this.useObservationTree;
    }

    /**
     * Sets the new value for the parameter {@code useObservationTree}.
     * @param useObservationTree the new value for the parameter {@code useObservationTree}
     */
    public void setUseObservationTree(boolean useObservationTree) {
        this.useObservationTree = useObservationTree;
    }

    /**
     * Sets the new value for the parameter {@code useObservationTree} and returns {@code this} builder instance.
     * @param useObservationTree the new value for the parameter {@code useObservationTree}
     * @return the current builder instance
     */
    public ADTLearnerBuilder<I, O> withUseObservationTree(boolean useObservationTree) {
        this.useObservationTree = useObservationTree;
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
    public ADTLearnerBuilder<I, O> withSuffixFinder(
            LocalSuffixFinder<? super I, ? super Word<O>> suffixFinder) {
        this.suffixFinder = suffixFinder;
        return this;
    }

    /**
     * Creates a new {@link ADTLearner} instance with the configured parameters.
     * @return the created instance
     */
    public ADTLearner<I, O> create() {
        return new ADTLearner<I, O>(alphabet, oracle, leafSplitter, adtExtender, subtreeReplacer, useObservationTree, suffixFinder);
    }
}
