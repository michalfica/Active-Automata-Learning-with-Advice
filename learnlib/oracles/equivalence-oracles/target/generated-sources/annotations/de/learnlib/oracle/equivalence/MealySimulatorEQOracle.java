package de.learnlib.oracle.equivalence;

import de.learnlib.oracle.EquivalenceOracle;
import de.learnlib.tooling.annotation.Generated;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.word.Word;

/**
 * A type-specific refinement of {@link SimulatorEQOracle}.
 * @param <I> input symbol type
 * @param <O> output symbol type
 */
@Generated(
        generator = "de.learnlib.tooling.processor.refinement.RefinementProcessor",
        source = "de.learnlib.oracle.equivalence.SimulatorEQOracle"
)
public class MealySimulatorEQOracle<I, O> extends SimulatorEQOracle<MealyMachine<?, I, ?, O>, I, Word<O>> implements EquivalenceOracle.MealyEquivalenceOracle<I, O> {
    /**
     * Delegates to {@link SimulatorEQOracle#public void <init>(net.automatalib.automaton.UniversalDeterministicAutomaton)}.
     * @param reference maps to the {@code reference} parameter of the delegate
     */
    public MealySimulatorEQOracle(MealyMachine<?, I, ?, O> reference) {
        super(reference);
    }
}
