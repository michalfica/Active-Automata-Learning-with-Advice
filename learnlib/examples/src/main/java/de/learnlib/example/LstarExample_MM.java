/* Copyright (C) 2013-2025 TU Dortmund University
 * This file is part of LearnLib <https://learnlib.de>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.learnlib.example;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import org.checkerframework.checker.nullness.qual.Nullable;

import de.learnlib.algorithm.LearningAlgorithm.MealyLearner;
import de.learnlib.algorithm.lstar.mealy.ExtensibleLStarMealyBuilder;
import de.learnlib.driver.reflect.MethodInput;
import de.learnlib.driver.reflect.MethodOutput;
import de.learnlib.driver.reflect.SimplePOJOTestDriver;
import de.learnlib.filter.cache.sul.SULCaches;
import de.learnlib.filter.statistic.Counter;
import de.learnlib.filter.statistic.sul.CounterSUL;
import de.learnlib.oracle.EquivalenceOracle.MealyEquivalenceOracle;
import de.learnlib.oracle.equivalence.mealy.RandomWalkEQOracle;
import de.learnlib.oracle.membership.SULOracle;
import de.learnlib.query.DefaultQuery;
import de.learnlib.statistic.StatisticSUL;
import de.learnlib.sul.SUL;
import de.learnlib.util.Experiment.MealyExperiment;
import de.learnlib.util.statistic.SimpleProfiler;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.automaton.transducer.MealyMachine;
import net.automatalib.serialization.dot.GraphDOT;
import net.automatalib.visualization.Visualization;
import net.automatalib.word.Word;
import net.automatalib.word.WordBuilder;

/**
 * This example shows how a model of a Java class can be learned using the SUL (system under learning) interfaces and
 * the random walks equivalence test.
 */
@SuppressWarnings("PMD.SystemPrintln")
public final class LstarExample_MM {

    private static final double RESET_PROBABILITY = 0.05;
    private static final int MAX_STEPS = 10_000;
    private static final int RANDOM_SEED = 46_346_293;

    private LstarExample_MM() {
        // prevent instantiation
    }

    public static class input_data{
        public MealyMachine<?, MethodInput, ?, MethodOutput> mm;
        public input_data(){

        }
        public input_data(MealyMachine<?, MethodInput, ?, MethodOutput> _mm) {
            mm = _mm;
        }
        
    }

    public static void main(String[] args) throws NoSuchMethodException, IOException {

        // instantiate test driver
        SimplePOJOTestDriver driver = new SimplePOJOTestDriver(BoundedStringQueue.class);

        // create learning alphabet
        Method mOffer = BoundedStringQueue.class.getMethod("offer", String.class);
        Method mPoll = BoundedStringQueue.class.getMethod("poll");

        // offer
        MethodInput offerA = driver.addInput("offer_a", mOffer, "a");
        MethodInput offerB = driver.addInput("offer_b", mOffer, "b");

        // poll
        MethodInput poll = driver.addInput("poll", mPoll);

        // oracle for counting queries wraps sul
        StatisticSUL<MethodInput, MethodOutput> statisticSul = new CounterSUL<>(driver);

        SUL<MethodInput, MethodOutput> effectiveSul = statisticSul;
        // use caching in order to avoid duplicate queries
        effectiveSul = SULCaches.createCache(driver.getInputs(), effectiveSul);

        SULOracle<MethodInput, MethodOutput> mqOracle = new SULOracle<>(effectiveSul);

        // create initial set of suffixes
        List<Word<MethodInput>> suffixes = new ArrayList<>();
        suffixes.add(Word.fromSymbols(offerA));
        suffixes.add(Word.fromSymbols(offerB));
        suffixes.add(Word.fromSymbols(poll));

        // construct L* instance (almost classic Mealy version)
        // almost: we use words (Word<String>) in cells of the table
        // instead of single outputs.
        MealyLearner<MethodInput, MethodOutput> lstar =
                new ExtensibleLStarMealyBuilder<MethodInput, MethodOutput>().withAlphabet(driver.getInputs()) // input alphabet
                                                                            .withOracle(mqOracle) // membership oracle
                                                                            .withInitialSuffixes(suffixes) // initial suffixes
                                                                            .create();

        // create random walks equivalence test
        MealyEquivalenceOracle<MethodInput, MethodOutput> randomWalks =
                new RandomWalkEQOracle<>(driver, // system under learning
                                         RESET_PROBABILITY, // reset SUL w/ this probability before a step
                                         MAX_STEPS, // max steps (overall)
                                         false, // reset step count after counterexample
                                         new Random(RANDOM_SEED) // make results reproducible
                );

        // construct a learning experiment from
        // the learning algorithm and the random walks test.
        // The experiment will execute the main loop of
        // active learning
        MealyExperiment<MethodInput, MethodOutput> experiment =
                new MealyExperiment<>(lstar, randomWalks, driver.getInputs());

        // turn on time profiling
        experiment.setProfile(true);

        // enable logging of models
        experiment.setLogModels(true);

        // run experiment
        experiment.run();

        // get learned model
        MealyMachine<?, MethodInput, ?, MethodOutput> result = experiment.getFinalHypothesis();

        Visualization.visualize(result, driver.getInputs());

        System.out.print("Alfabet wejściowy: " + driver.getInputs());
        System.out.print("Stany maszyny: " + result.getStates());
        
        // for(  )
        // report results
        System.out.println("-------------------------------------------------------");

        // profiling
        SimpleProfiler.logResults();

        // learning statistics
        System.out.println(experiment.getRounds().getSummary());
        System.out.println(statisticSul.getStatisticalData().getSummary());

        // model statistics
        System.out.println("States: " + result.size());
        System.out.println("Sigma: " + driver.getInputs().size());

        // show model
        System.out.println();
        System.out.println("Model: ");

        GraphDOT.write(result, driver.getInputs(), System.out); // may throw IOException!
        // Visualization.visualize(result, driver.getInputs());

        System.out.println("-------------------------------------------------------");


        // NOW LEARNING WITH ADVICE SYSTEM 
        System.out.print("A TERAZ UCZENIE SIE Z ADVIE SYSTEM !!!");
        System.out.print(result.getClass().getSimpleName());
        input_data target = new input_data();
        target.mm = result;

        statisticSul = new CounterSUL<>(driver);
        effectiveSul = statisticSul;
        effectiveSul = SULCaches.createCache(driver.getInputs(), effectiveSul);
        mqOracle = new SULOracle<>(effectiveSul);
        lstar = new ExtensibleLStarMealyBuilder<MethodInput, MethodOutput>().withAlphabet(driver.getInputs()) // input alphabet
                                                                            .withOracle(mqOracle) // membership oracle
                                                                            .withInitialSuffixes(suffixes) // initial suffixes
                                                                            .create();
        randomWalks =
        new RandomWalkEQOracle<>(driver, // system under learning
                                    RESET_PROBABILITY, // reset SUL w/ this probability before a step
                                    MAX_STEPS, // max steps (overall)
                                    false, // reset step count after counterexample
                                    new Random(RANDOM_SEED) // make results reproducible
        );
        result = runExperiment(target, lstar, randomWalks, driver.getInputs());
        System.out.println(statisticSul.getStatisticalData().getSummary());
    }

    public static MealyMachine<?, MethodInput, ?, MethodOutput> runExperiment( input_data target, MealyLearner<MethodInput, MethodOutput> learningAlgorithm, MealyEquivalenceOracle<MethodInput, MethodOutput> equivalenceAlgorithm, Alphabet<MethodInput> inputs)throws IOException{
        Counter rounds = new Counter("Learning rounds", "#");
        System.out.println("RUN EXPERIMENT");
        rounds.increment();
        learningAlgorithm.startLearning();
        while (true) {
            System.out.print("Starting round: ");
            System.out.print(rounds.getCount());
            System.out.print("\n");

            MealyMachine<Integer, MethodInput, ?, MethodOutput> hyp = (MealyMachine<Integer, MethodInput, ?, MethodOutput>) learningAlgorithm.getHypothesisModel();
            DefaultQuery<MethodInput, Word<MethodOutput>> ceFromConsistencyCheck = checkConsistencywithSRS(target, hyp, inputs);
            System.out.println("ceFromConsistencyCheck = " + ceFromConsistencyCheck);
            // Visualization.visualize(hyp, inputs);
            while( ceFromConsistencyCheck!=null ){
                final boolean refined = learningAlgorithm.refineHypothesis(ceFromConsistencyCheck);
                assert refined;
                hyp = (MealyMachine<Integer, MethodInput, ?, MethodOutput>)  learningAlgorithm.getHypothesisModel();
                ceFromConsistencyCheck = checkConsistencywithSRS(target, hyp, inputs);
                System.out.println("ceFromConsistencyCheck = " + ceFromConsistencyCheck);
                // Visualization.visualize(hyp, inputs);
            }

            // final MealyMachine<?, MethodInput, ?, MethodOutput> hyp = learningAlgorithm.getHypothesisModel();
            DefaultQuery<MethodInput, Word<MethodOutput>> ce = equivalenceAlgorithm.findCounterExample(hyp, inputs);

            if (ce == null) {
                return hyp;
            }
            // next round ...
            rounds.increment();
            final boolean refined = learningAlgorithm.refineHypothesis(ce);
            assert refined;
        }
    }

    public static DefaultQuery<MethodInput, Word<MethodOutput>> checkConsistencywithSRS(input_data target, MealyMachine<Integer, MethodInput, ?, MethodOutput> hyp, Alphabet<MethodInput> inputs)throws IOException{
        // System.out.println(hyp.getStates().getClass().getSimpleName());
        HashMap<Integer, Word<MethodInput>> access_sequences = computeAccessSequences(hyp, inputs);

        for( Integer q :  hyp.getStates()){
            
            // (inputs[idenpotent_letter], inputs[idenpotent_letter]inputs[idenpotent_letter]) \in Advice System  
            for( int i=0; i<inputs.size(); i++ ){
                Word<MethodInput> w1 = convertToWord(inputs.apply(i), 3);
                Word<MethodInput> w2 = convertToWord(inputs.apply(i), 4);

                Integer q1 = hyp.getSuccessor(q, w1);
                Integer q2 = hyp.getSuccessor(q, w2);
                System.out.print(q + " + " + w1 + " to  q1 =  " + q1 + "\n" + q + " + " + w2 + " to q2 = " + q2 +"\n");
                if( q1.intValue()!= q2.intValue() ){  // inconsistency with Advice System 
                    Word<MethodInput> potentialCe1 = access_sequences.get(q).concat(w1);
                    Word<MethodInput> potentialCe2 = access_sequences.get(q).concat(w2);
                    Word<MethodInput> sep = findDistinguishingWord(hyp, inputs, q1, q2);
                    potentialCe1 = potentialCe1.concat(sep);
                    potentialCe2 = potentialCe2.concat(sep);

                    // System.out.print("potence1 : " + potentialCe1 + " potence2 : " + potentialCe2 +'\n');
                    Word<MethodOutput> status = target.mm.computeOutput(potentialCe1);
                    // System.out.print(status + "\n");
                    // System.out.print(hyp.computeOutput(potentialCe1) + "\n");

                    if( status.toString() == null ? hyp.computeOutput(potentialCe1).toString() != null : !status.toString().equals(hyp.computeOutput(potentialCe1).toString())){
                        return new DefaultQuery<>(potentialCe1, status);
                    }
                    else{
                        return new DefaultQuery<>(potentialCe2, target.mm.computeOutput(potentialCe2));
                    }
                }
            }
        }
        return null;
    }

        // For every state find an access sequence 
    private static HashMap<Integer, Word<MethodInput>> computeAccessSequences(MealyMachine<Integer, MethodInput, ?, MethodOutput> mm, Alphabet<MethodInput> alphabet) {
        Queue<Integer> queue = new LinkedList<>();
        queue.clear();

        HashMap<Integer, Word<MethodInput>> visited = new HashMap<>();
        visited.clear();

        Integer q0 = mm.getInitialState();
        visited.put(q0, convertToWord(alphabet.apply(0), 0) );

        queue.add(q0);

        while(!queue.isEmpty()){

            Integer q = queue.poll();
            for(MethodInput symbol : alphabet ){
                Integer next_q = mm.getSuccessor(q, convertToWord(symbol, 1));
                if( visited.get(next_q)== null){

                    WordBuilder<MethodInput> wb = new WordBuilder<>(null, 0);
                    wb.append(visited.get(q));
                    wb.append(symbol);

                    visited.put(next_q, wb.toWord());
                    queue.add(next_q);
                }
            }
        }
        return visited; // No distinguishing word found
    }

        // Find a distinguishing word for two DFA states
    private static Word<MethodInput> findDistinguishingWord(MealyMachine<Integer, MethodInput, ?, MethodOutput> mm, Alphabet<MethodInput> alphabet, Integer q1, Integer q2) {
        Queue<Word<MethodInput>> queue = new LinkedList<>();
        queue.clear();
        queue.add(convertToWord(alphabet.apply(0), 0));

        HashSet<String> visited = new HashSet<>();
        visited.clear();
        visited.add(q1.toString()+"#"+q2.toString());

        while (!queue.isEmpty()) {
            Word<MethodInput> word = queue.poll();

            if (mm.computeStateOutput(q1,word).toString() == null ? mm.computeStateOutput(q2, word).toString() != null : !mm.computeStateOutput(q1,word).toString().equals(mm.computeStateOutput(q2, word).toString())) {
                return word; // Found a distinguishing word
            }

            for (MethodInput symbol : alphabet) {
                Word<MethodInput> new_word= word.append(symbol);

                String next_q1 = mm.getSuccessor(q1, new_word).toString();
                String next_q2 = mm.getSuccessor(q2, new_word).toString();

                if( !visited.contains(next_q1 + "#" + next_q2)){
                    queue.add(new_word);
                    visited.add(next_q1 + "#" + next_q2);
                }
            }
        }
        return null; // No distinguishing word found
    }

    private static Word<MethodInput> convertToWord(MethodInput a, int k){
        WordBuilder<MethodInput> wb = new WordBuilder<>(null, 0);
        for( int i=0; i<k; i++){
            wb.append(a);
        }
        Word<MethodInput> word = wb.toWord();
        return word;
    }

    /*
     * The BoundedStringQueue is the class of which we are going to
     * infer a model. It wraps an ordinary queue of Strings, limiting
     * its size to MAX_SIZE (3). Once the queue is full, additional
     * offers will be ignored.
     * <p>
     * However, the implementation uses the underlying queue in a strange
     * way as the model will reveal.
     */
    public static class BoundedStringQueue {

        // capacity
        public static final int MAX_SIZE = 3;
        // storage
        private final Deque<String> data = new ArrayDeque<>(3);

        // add a String to the queue if capacity allows
        public void offer(String s) {
            if (data.size() < MAX_SIZE) {
                data.offerFirst(s);
            }
        }

        // get next element from queue (null for empty queue)
        public @Nullable String poll() {
            return data.poll();
        }
    }
}
