package de.learnlib.algorithm.lsharp;

import de.learnlib.oracle.AdaptiveMembershipOracle;
import de.learnlib.tooling.annotation.Generated;
import java.util.Random;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.word.Word;

/**
 * A builder for constructing {@link LSharpMealy} instances.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.builder.BuilderProcessor",
        source = "de.learnlib.algorithm.lsharp.LSharpMealy"
)
public final class LSharpMealyBuilder<I, O> {
    private Alphabet<I> alphabet;

    private AdaptiveMembershipOracle<I, O> oracle;

    private Rule2 rule2;

    private Rule3 rule3;

    private Word<I> sinkState;

    private O sinkOutput;

    private Random random;

    /**
     * Creates a new builder (and may set default values for some parameters).
     */
    public LSharpMealyBuilder() {
        this.rule2 = de.learnlib.algorithm.lsharp.LSharpMealy.BuilderDefaults.rule2();
        this.rule3 = de.learnlib.algorithm.lsharp.LSharpMealy.BuilderDefaults.rule3();
        this.sinkState = de.learnlib.algorithm.lsharp.LSharpMealy.BuilderDefaults.sinkState();
        this.sinkOutput = de.learnlib.algorithm.lsharp.LSharpMealy.BuilderDefaults.sinkOutput();
        this.random = de.learnlib.algorithm.lsharp.LSharpMealy.BuilderDefaults.random();
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
    public LSharpMealyBuilder<I, O> withAlphabet(Alphabet<I> alphabet) {
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
    public LSharpMealyBuilder<I, O> withOracle(AdaptiveMembershipOracle<I, O> oracle) {
        this.oracle = oracle;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code rule2}.
     * @return the current value for the parameter {@code rule2}
     */
    public Rule2 getRule2() {
        return this.rule2;
    }

    /**
     * Sets the new value for the parameter {@code rule2}.
     * @param rule2 the new value for the parameter {@code rule2}
     */
    public void setRule2(Rule2 rule2) {
        this.rule2 = rule2;
    }

    /**
     * Sets the new value for the parameter {@code rule2} and returns {@code this} builder instance.
     * @param rule2 the new value for the parameter {@code rule2}
     * @return the current builder instance
     */
    public LSharpMealyBuilder<I, O> withRule2(Rule2 rule2) {
        this.rule2 = rule2;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code rule3}.
     * @return the current value for the parameter {@code rule3}
     */
    public Rule3 getRule3() {
        return this.rule3;
    }

    /**
     * Sets the new value for the parameter {@code rule3}.
     * @param rule3 the new value for the parameter {@code rule3}
     */
    public void setRule3(Rule3 rule3) {
        this.rule3 = rule3;
    }

    /**
     * Sets the new value for the parameter {@code rule3} and returns {@code this} builder instance.
     * @param rule3 the new value for the parameter {@code rule3}
     * @return the current builder instance
     */
    public LSharpMealyBuilder<I, O> withRule3(Rule3 rule3) {
        this.rule3 = rule3;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code sinkState}.
     * @return the current value for the parameter {@code sinkState}
     */
    public Word<I> getSinkState() {
        return this.sinkState;
    }

    /**
     * Sets the new value for the parameter {@code sinkState}.
     * @param sinkState the new value for the parameter {@code sinkState}
     */
    public void setSinkState(Word<I> sinkState) {
        this.sinkState = sinkState;
    }

    /**
     * Sets the new value for the parameter {@code sinkState} and returns {@code this} builder instance.
     * @param sinkState the new value for the parameter {@code sinkState}
     * @return the current builder instance
     */
    public LSharpMealyBuilder<I, O> withSinkState(Word<I> sinkState) {
        this.sinkState = sinkState;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code sinkOutput}.
     * @return the current value for the parameter {@code sinkOutput}
     */
    public O getSinkOutput() {
        return this.sinkOutput;
    }

    /**
     * Sets the new value for the parameter {@code sinkOutput}.
     * @param sinkOutput the new value for the parameter {@code sinkOutput}
     */
    public void setSinkOutput(O sinkOutput) {
        this.sinkOutput = sinkOutput;
    }

    /**
     * Sets the new value for the parameter {@code sinkOutput} and returns {@code this} builder instance.
     * @param sinkOutput the new value for the parameter {@code sinkOutput}
     * @return the current builder instance
     */
    public LSharpMealyBuilder<I, O> withSinkOutput(O sinkOutput) {
        this.sinkOutput = sinkOutput;
        return this;
    }

    /**
     * Returns the current value for the parameter {@code random}.
     * @return the current value for the parameter {@code random}
     */
    public Random getRandom() {
        return this.random;
    }

    /**
     * Sets the new value for the parameter {@code random}.
     * @param random the new value for the parameter {@code random}
     */
    public void setRandom(Random random) {
        this.random = random;
    }

    /**
     * Sets the new value for the parameter {@code random} and returns {@code this} builder instance.
     * @param random the new value for the parameter {@code random}
     * @return the current builder instance
     */
    public LSharpMealyBuilder<I, O> withRandom(Random random) {
        this.random = random;
        return this;
    }

    /**
     * Creates a new {@link LSharpMealy} instance with the configured parameters.
     * @return the created instance
     */
    public LSharpMealy<I, O> create() {
        return new LSharpMealy<I, O>(alphabet, oracle, rule2, rule3, sinkState, sinkOutput, random);
    }
}
