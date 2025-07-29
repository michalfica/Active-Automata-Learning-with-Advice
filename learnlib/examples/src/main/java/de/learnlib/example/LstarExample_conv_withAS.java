package de.learnlib.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import de.learnlib.algorithm.lstar.dfa.ClassicLStarDFA;
import de.learnlib.algorithm.lstar.dfa.ClassicLStarDFABuilder;
import de.learnlib.filter.cache.dfa.DFACacheOracle;
import de.learnlib.filter.cache.dfa.DFACaches;
import de.learnlib.filter.statistic.Counter;
import de.learnlib.filter.statistic.oracle.DFACounterOracle;
import de.learnlib.oracle.EquivalenceOracle.DFAEquivalenceOracle;
import de.learnlib.oracle.MembershipOracle.DFAMembershipOracle;
import de.learnlib.oracle.equivalence.DFASimulatorEQOracle;
import de.learnlib.oracle.membership.DFASimulatorOracle;
import de.learnlib.query.DefaultQuery;
import net.automatalib.alphabet.Alphabet;
import net.automatalib.alphabet.impl.Alphabets;
import net.automatalib.alphabet.impl.GrowingMapAlphabet;
import net.automatalib.automaton.fsa.DFA;
import net.automatalib.automaton.fsa.impl.CompactDFA;
import net.automatalib.util.automaton.builder.AutomatonBuilders;
import net.automatalib.util.automaton.equivalence.DeterministicEquivalenceTest;
import net.automatalib.word.Word;
import net.automatalib.word.WordBuilder;

public class LstarExample_conv_withAS {
    private static final String DFA_DESCRIPTION_FILE = "../../learnlib/examples/src/main/java/de/learnlib/example/DfaEx.txt";

    private static final char[] engAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private LstarExample_conv_withAS(){
    }

    private static Word<Character> convertStringToWord(String w){
        WordBuilder<Character> wb = new WordBuilder<>(null, 0);
        for( char c : w.toCharArray()){
            wb.append(c);
        }
        Word<Character> word = wb.toWord();
        return word;
    }

    // Find a distinguishing word for two DFA states
    private static Word<Character> findDistinguishingWord(DFA<Integer, Character> dfa, Alphabet<Character> alphabet, Integer q1, Integer q2) {
        Queue<String> queue = new LinkedList<>();
        queue.clear();
        queue.add("");

        HashSet<String> visited = new HashSet<>();
        visited.clear();
        visited.add(q1.toString()+"#"+q2.toString());

        while (!queue.isEmpty()) {
            String w = queue.poll();
            Word<Character> word = convertStringToWord(w);

            if (dfa.computeStateOutput(q1,word).booleanValue() != dfa.computeStateOutput(q2, word).booleanValue()) {
                return word; // Found a distinguishing word
            }

            for (Character symbol : alphabet) {
                String next_q1 = dfa.getSuccessor(q1, convertStringToWord(w+symbol)).toString();
                String next_q2 = dfa.getSuccessor(q2, convertStringToWord(w+symbol)).toString();

                if( !visited.contains(next_q1 + "#" + next_q2)){
                    queue.add(w + symbol);
                    visited.add(next_q1 + "#" + next_q2);
                }
            }
        }
        return null; // No distinguishing word found
    }

    // For every state find an access sequence 
    private static HashMap<Integer, String> computeAccessSequences(DFA<Integer, Character> dfa, Alphabet<Character> alphabet) {
        Queue<Integer> queue = new LinkedList<>();
        queue.clear();

        HashMap<Integer, String> visited = new HashMap<>();
        visited.clear();

        Integer q0 = dfa.getInitialState();
        visited.put(q0, "");

        queue.add(q0);

        while(!queue.isEmpty()){

            Integer q = queue.poll();
            for(Character symbol : alphabet ){
                Integer next_q = dfa.getSuccessor(q, symbol);
                if( visited.get(next_q)== null){
                    visited.put(next_q, visited.get(q)+symbol);
                    queue.add(next_q);
                }
            }
        }
        return visited; // No distinguishing word found
    }

    public static DefaultQuery<Character, Boolean> checkConsistencywithSRS(CompactDFA<Character> target, DFA<Integer, Character> hyp, Alphabet<Character> inputs)throws IOException{
        // System.out.println(hyp.getStates().getClass().getSimpleName());
        HashMap<Integer, String> access_sequences = computeAccessSequences(hyp, inputs);
        int inputs_size = inputs.size();
        for( int i=0; i<inputs_size/2; i++){
            for( int j=inputs_size/2; j<inputs_size; j++){  
                for( Integer q :  hyp.getStates()){
                    
                    // (inputs[i]inputs[j], inputs[j]inputs[i]) \in Advice System  
                    Integer q1 = hyp.getSuccessor(q, convertStringToWord(inputs.apply(i).toString() + inputs.apply(j).toString()));
                    Integer q2 = hyp.getSuccessor(q, convertStringToWord(inputs.apply(j).toString() + inputs.apply(i).toString()));
                    
                    if( q1.intValue()!= q2.intValue() ){  // inconsistency with Advice System 
                        Word<Character> potentialCe1 = convertStringToWord(access_sequences.get(q)).append(inputs.apply(i)).append(inputs.apply(j));
                        Word<Character> potentialCe2 = convertStringToWord(access_sequences.get(q)).append(inputs.apply(j)).append(inputs.apply(i));
                        Word<Character> sep = findDistinguishingWord(hyp, inputs, q1, q2);
                        potentialCe1 = potentialCe1.concat(sep);
                        potentialCe2 = potentialCe2.concat(sep);

                        Boolean status = target.computeOutput(potentialCe1);

                        if( status.booleanValue()!=hyp.computeOutput(potentialCe1).booleanValue()){
                            return new DefaultQuery<>(potentialCe1, status);
                        }
                        else{
                            return new DefaultQuery<>(potentialCe2, target.computeOutput(potentialCe2));
                        }
                    }
                }
            }
        }
        return null;
    }

    public static DFA<?, Character> runExperiment(CompactDFA<Character> target, ClassicLStarDFA<Character> learningAlgorithm, DFAEquivalenceOracle<Character> equivalenceAlgorithm, Alphabet<Character> inputs) throws IOException{
        Counter rounds = new Counter("Learning rounds", "#");
        System.out.println("RUN EXPERIMENT");
        rounds.increment();
        learningAlgorithm.startLearning();
        
        while (true) {
            System.out.print("Starting round: ");
            System.out.print(rounds.getCount());
            System.out.print("\n");

            DFA<Integer, Character> hyp = (DFA<Integer, Character>) learningAlgorithm.getHypothesisModel();

            DefaultQuery<Character, Boolean> ceFromConsistencyCheck = checkConsistencywithSRS(target, hyp, inputs);
            while( ceFromConsistencyCheck!=null ){
                final boolean refined = learningAlgorithm.refineHypothesis(ceFromConsistencyCheck);
                assert refined;
                hyp = (DFA<Integer, Character>)  learningAlgorithm.getHypothesisModel();
                ceFromConsistencyCheck = checkConsistencywithSRS(target, hyp, inputs);
            }

            DefaultQuery<Character, Boolean> ce = equivalenceAlgorithm.findCounterExample(hyp, inputs);

            if (ce == null) {
                System.out.println("Learning rounds: " + rounds.getCount());
                return hyp;
            }

            // next round ...
            rounds.increment();
            final boolean refined = learningAlgorithm.refineHypothesis(ce);
            assert refined;
        }

        // return null; 
    }

    public static void main(String[] args) throws IOException{
        
        // load DFA and alphabet
        CompactDFA<Character> target = constructSUL();
        Alphabet<Character> sigma = target.getInputAlphabet();

        // construct a simulator membership query oracle
        DFAMembershipOracle<Character> sul = new DFASimulatorOracle<>(target);
        // oracle for counting queries wraps sul
        DFACounterOracle<Character> mqOracle = new DFACounterOracle<>(sul);
        // create cache oracle
        DFACacheOracle<Character> cacheOracle = DFACaches.createCache(new GrowingMapAlphabet<>(sigma), mqOracle);
        // create a learner
        ClassicLStarDFA<Character> learner = 
                new ClassicLStarDFABuilder<Character>().withAlphabet(sigma)
                                                       .withOracle(cacheOracle)
                                                       .create();
        
        // create equivalence query oracle 
        DFAEquivalenceOracle<Character> eqOracle = new DFASimulatorEQOracle<>(target);
        
        // run experiment and get the result
        final DFA<?, Character> result = runExperiment(target, learner, eqOracle, sigma);
        // assert we have the correct result
        System.out.print(DeterministicEquivalenceTest.findSeparatingWord(target, result, sigma));

        System.out.println(mqOracle.getStatisticalData().getSummary());
    }


    private static CompactDFA<Character> constructSUL() throws FileNotFoundException{
        File dfaDesc = new File(DFA_DESCRIPTION_FILE);
        CompactDFA<Character > dfa;
        try (Scanner dfaReader = new Scanner(dfaDesc)) {
            String data = dfaReader.nextLine();
            int n = Integer.parseInt(data.split(" ")[0]);
            int sigma_size = Integer.parseInt(data.split(" ")[1]);

            Alphabet<Character> sigma = Alphabets.characters(engAlphabet[0],engAlphabet[sigma_size-1]);
            dfa = AutomatonBuilders.newDFA(sigma).withInitial("q0").create();
            for( int i=1; i<n; i++){
                dfa.addState();
            }   
            for( int i=0; i<n; i++){
                data = dfaReader.nextLine();
                String[] transitions = data.split(" ");
                for( int j=0; j<sigma_size; j++ ){
                    dfa.addTransition(i, engAlphabet[j], Integer.parseInt(transitions[j]));
                }
            }   data = dfaReader.nextLine();
            String[] acceptingStates = data.split(" ");
            for(String state:   acceptingStates){
                dfa.setAccepting(Integer.parseInt(state), true);
            }
        }
        return dfa; 
    }
 
}