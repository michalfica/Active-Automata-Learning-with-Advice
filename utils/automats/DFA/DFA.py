from queue import Queue
from itertools import product
import random
import string

import subprocess

from collections import defaultdict


class DFA:
    """
    Q                   - number of states,
    input_signs         - input alphabet,
    δ                   - transitions function (q,a) -> q'
    F                   - set of accepting states
    """

    NO_ANSWER = ""
    ACCEPT = 1
    NOT_DEFINED, SIMPLE_DFA = "not_defined", "DFA"
    RANDOM_DFA = "randomDFA"
    CONV_DFA = "convDFA"
    CONV_DFA_WITH_COMMON = "convDFAwithCommon"
    BITWISE_ADDITION = "bitwise_addition"
    AND_TYPE_PATTERN_DFA, OR_TYPE_PATTERN_DFA = "AND", "OR"
    EMPTY_STRING = ""
    NOT_RESETING_WORD = "-1"
    STATE_NOT_ACCESSIBLE = "-1"
    INDEMPOTENT = "idempotent"

    def __init__(self, Q=0, input_signs=None, δ=None, F=None, type_=NOT_DEFINED):
        if input_signs is None:
            input_signs = []
        if δ is None:
            δ = dict()
        if F is None:
            F = set()

        self.Q = Q
        self.input_signs = input_signs
        self.common_letters = None

        self.indempotent_letter = None

        self.output_signs = []
        self.δ = δ
        self.F = F
        self.type = type_
        self.reset_word = DFA.NOT_RESETING_WORD

        self.mapping = dict()
        self.pruned = False
        self.selectors = dict()

    def __str__(self):
        return f"DFA amount of states = {self.Q}, transitions = {self.δ}, accept states = {self.F}"

    def print_transitions(self):
        for q in range(self.Q):
            from_q = str(q) + ": \n"
            for a in self.input_signs:
                if (q, a) not in self.δ:
                    if self.pruned:
                        continue
                    # TO DO: nie jestem pewny czy ten assert jest dobrze napisany !
                    assert False, f"There is no such ({q}, {a}) trasition in automaton!"
                # print(f"({q},{a}) --> {self.δ[(q,a)]}")
                from_q += a + " " + str(self.δ[(q, a)]) + "; "
            print(from_q)

    def print_dfa(self):
        print(f"alphabet: {self.input_signs}")
        print(f"transitions: ")
        self.print_transitions()
        print(f"Accepting states - {self.F}")

    def dfa_from_dot_file(self, file_name):
        f = open(file=file_name, mode="r")

        number_of_states = 1
        alphabet_size = 0

        inputs_mapping = defaultdict(int)
        for line in f:
            line = line.strip()
            elements = line.split(" ")
            # print(f"ELEMENTS: {elements}\n\n")

            if len(elements) == 1 and elements[0][0] == "s":
                number_of_states += 1
                # print(f"element = {elements}, ADDING NEW STATE")

            if len(elements) >= 2 and elements[1] == "->":
                q1 = int(elements[0][1:])
                q2 = int(elements[2][1 : elements[2].find("[")])

                label = elements[-1][elements[-1].find("tr><td>") + 1 : -3]

                if label not in inputs_mapping:
                    inputs_mapping[label] = alphabet_size
                    alphabet_size += 1

                self.δ[(q1, string.ascii_letters[inputs_mapping[label]])] = q2
                # print(f"numerek literk: {inputs_mapping[label]}")
                # print(f"{q1}, {string.ascii_letters[inputs_mapping[label]]} -> {q2}")

        self.Q = number_of_states + 1  # adding śmietnik
        self.input_signs = [a for a in string.ascii_letters[:alphabet_size]]

        trash_can = number_of_states + 1
        for a in self.input_signs:
            self.δ[(trash_can, a)] = trash_can

        for q in range(self.Q):
            for a in self.input_signs:
                if (q, a) not in self.δ:
                    self.δ[(q, a)] = trash_can

    def print_java_format(self):
        result = (
            "Alphabet<Character> sigma = Alphabets.characters('a', '"
            + string.ascii_lowercase[len(self.input_signs) - 1]
            + "');\n"
        )
        result += "AutomatonBuilders.newDFA(sigma)\n"
        result += ' .withInitial("q0")\n'
        for q in range(self.Q):
            result += ' .from("q' + str(q) + '")\n'
            for i, a in enumerate(self.input_signs):
                if (q, a) not in self.δ:
                    if self.pruned:
                        continue
                    # TO DO: nie jestem pewny czy ten assert jest dobrze napisany !
                    assert False, f"There is no such ({q}, {a}) trasition in automaton!"
                result += (
                    "     .on('"
                    + string.ascii_lowercase[i]
                    + "').to(\"q"
                    + str(self.δ[(q, a)])
                    + '")\n'
                )
        accept_states = ", ".join(['"q' + str(q) + '"' for q in list(self.F)])
        result += " .withAccepting(" + accept_states + ")\n"
        result += " .create();"
        return result

    """ 
    returns string - complete descreption of dfa in the following format:

    n - number of states, m - size of alphabet 
    transitions 
    accepting states 
    """

    def print_complete_description(self):
        s = ""
        s += str(self.Q) + " " + str(len(self.input_signs))
        if self.type == DFA.CONV_DFA_WITH_COMMON:
            s += " " + str((len(self.input_signs) - len(self.common_letters)) // 2)
            s += " " + str(
                (len(self.input_signs) - len(self.common_letters)) // 2
                + len(self.common_letters)
                - 1
            )
        if self.type == DFA.INDEMPOTENT:
            s += " " + str(self.input_signs.index(self.indempotent_letter))
        s += "\n"
        for q in range(self.Q):
            for a in self.input_signs:
                s += str(self.δ[(q, a)]) + " "
            s += "\n"
        for q in list(self.F):
            s += str(q) + " "
        return s

    def route(self, w, q0=0, route_and_return_q=False):
        q = q0
        for a in w:
            assert (q, a) in self.δ, "There is no such trasition in automaton!"
            q = self.δ[(q, a)]
        if route_and_return_q:
            return q

        if q in self.F:
            return (w, 1)
        return (w, 0)

    def route_and_return_q(self, w, q0=0):
        q = q0
        for a in w:
            if self.pruned and (q, a) not in self.δ:
                return DFA.STATE_NOT_ACCESSIBLE

            assert (q, a) in self.δ, "There is no such trasition in automaton!"
            q = self.δ[(q, a)]
        return q

    def find_selectors(self):

        def BFS():
            visited = dict()
            Q = Queue()
            selectors = dict()

            def addToQueue(state, w):
                if not state in visited:
                    visited[state] = True
                    selectors[state] = w[1:]
                    Q.put((state, w))

            addToQueue(0, "0")
            while not Q.empty():
                q, w = Q.get()
                for a in self.input_signs:
                    if self.pruned and (q, a) not in self.δ:
                        continue
                    else:
                        addToQueue(self.δ[(q, a)], w + a)
            return selectors

        return BFS()

    def find_accepting_word(self, start_state=0):

        def BFS():
            visited = dict()
            Q = Queue()

            def addToQueue(state, w):
                if not state in visited:
                    visited[state] = True
                    Q.put((state, w))

            addToQueue(start_state, "0")
            while not Q.empty():
                q, w = Q.get()
                if q in self.F:
                    return w
                for a in self.input_signs:
                    addToQueue(self.δ[(q, a)], w + a)
            return ""

        accepted_word = BFS()
        if accepted_word == "":
            return (False, "")
        return (True, accepted_word[1:])

    """
    Retuened values:
        when automatons have different alphabets: 1 
        when automatons are equivalent: ""
        other wise : a counter example 
    """

    def equiv(self, other):

        def BFS():
            visited = dict()
            Q = Queue()

            def addToQueue(state, w):
                if not state in visited:
                    visited[state] = True
                    Q.put((state, w))

            addToQueue((0, 0), "0")
            while not Q.empty():
                item = Q.get()
                q1, q2, w = item[0][0], item[0][1], item[1]
                if (q1 in self.F and q2 not in other.F) or (
                    q1 not in self.F and q2 in other.F
                ):
                    return w
                for a in self.input_signs:
                    addToQueue((self.δ[(q1, a)], other.δ[(q2, a)]), w + a)
            return ""

        if not self.input_signs == other.input_signs:
            assert False, "Different alphabets!"
        counterexample = BFS()
        if counterexample == "":
            return (True, "")
        return (False, counterexample[1:])

    def equiv_dfs(self, other):
        visited = dict()
        alp = []
        alp.extend([a for a in self.input_signs if a.islower()])
        alp.extend([a for a in self.input_signs if a.isupper()])

        def DFS(state, w):
            visited[state] = True
            q1, q2 = state
            if (q1 in self.F and q2 not in other.F) or (
                q1 not in self.F and q2 in other.F
            ):
                return w

            for a in alp:
                u1, u2 = self.δ[(q1, a)], other.δ[(q2, a)]
                if (u1, u2) not in visited:
                    s = DFS((u1, u2), w + a)
                    if s != "":
                        return s

            return ""

        if not self.input_signs == other.input_signs:
            assert False, "Different alphabets!"
        counterexample = DFS((0, 0), "0")
        if counterexample == "":
            return (True, "")
        return (False, counterexample[1:])

    """
    The function is given two automata and creates their convolution.

        Alphabet designation convention:
            * subset of input_signs consisting of only LOWER letters create the alphabet of the dfa1 machine,
            * subset of input_signs consisting of only UPPERCASE letters form the alphabet of the dfa2 machine.

    """

    def _compute_state_transitions_for_conv(self, dfa1, dfa2):

        def find_new_state(q, a):
            if a.isupper():
                if a.lower() not in set(dfa2.input_signs):  # add self loop
                    return self.state_mapping[(q[0], q[1])]
                return self.state_mapping[(q[0], dfa2.δ[(q[1], a.lower())])]
            else:
                if a.lower() not in set(dfa1.input_signs):  # add self loop
                    return self.state_mapping[(q[0], q[1])]
                return self.state_mapping[(dfa1.δ[(q[0], a)], q[1])]

        nested_loop1, nested_loop2 = product(range(dfa1.Q), range(dfa2.Q)), product(
            range(dfa1.Q), range(dfa2.Q)
        )

        cnt = 0
        for x in nested_loop1:
            self.state_mapping[x] = cnt
            cnt += 1
        for x in nested_loop2:
            for a in self.input_signs:
                self.δ[(self.state_mapping[x], a)] = find_new_state(x, a)

    def create_convolution(self, dfa1, dfa2):
        self.type = DFA.CONV_DFA
        self.Q = dfa1.Q * dfa2.Q
        self.input_signs = dfa1.input_signs + [a.upper() for a in dfa2.input_signs]
        self.state_mapping = dict()
        self._compute_state_transitions_for_conv(dfa1, dfa2)
        self.F = set([self.state_mapping[q] for q in product(dfa1.F, dfa2.F)])

    """
    The function is given two automata and creates their convolution BUT WITH COMMON LETTERS! 
    """

    def _compute_state_transitions_for_conv_with_common_letters(
        self, dfa1, dfa2, common_letters
    ):

        def find_new_state(q, a):
            if a in set(common_letters):
                return self.state_mapping[(dfa1.δ[(q[0], a)], dfa2.δ[(q[1], a)])]
            else:
                if a in set(dfa1.input_signs):
                    return self.state_mapping[(dfa1.δ[(q[0], a)], q[1])]
                else:
                    return self.state_mapping[(q[0], dfa2.δ[(q[1], a)])]

        nested_loop1, nested_loop2 = product(range(dfa1.Q), range(dfa2.Q)), product(
            range(dfa1.Q), range(dfa2.Q)
        )

        cnt = 0
        for x in nested_loop1:
            self.state_mapping[x] = cnt
            cnt += 1
        for x in nested_loop2:
            for a in self.input_signs:
                self.δ[(self.state_mapping[x], a)] = find_new_state(x, a)

    def create_convolution_with_common_letters(self, dfa1, dfa2):
        self.type = DFA.CONV_DFA_WITH_COMMON
        self.Q = dfa1.Q * dfa2.Q
        """
        Kolejnosć liter na liście jest bardzo istotna POLEGA NA TYM SRS !!! 
        """
        self.common_letters = [
            a for a in dfa1.input_signs if a in set(dfa2.input_signs)
        ]
        self.input_signs = [a for a in dfa1.input_signs]
        for a in dfa2.input_signs:
            if a not in set(self.input_signs):
                self.input_signs.append(a)

        self.state_mapping = dict()
        self._compute_state_transitions_for_conv_with_common_letters(
            dfa1, dfa2, self.common_letters
        )
        self.F = set([self.state_mapping[q] for q in product(dfa1.F, dfa2.F)])

    """
    A function that creates an automaton that accepts words containing patterns. There are 2 possible types:
        AND - ALL patterns specified in the 'patterns' field must appear in the word,
        OR - the word must contain AT LEAST 1 pattern specified in the 'patterns' field (except EMPTY_STRING), 
                additionally, if EMPTY_STRING appears in 'patterns', the initial state also includes the accepting states. 
    """

    def create_pattern_dfa(self, input_signs, patterns, _type=AND_TYPE_PATTERN_DFA):
        assert len(set(patterns)) == len(patterns), "All patterns must be different!"
        assert _type == DFA.OR_TYPE_PATTERN_DFA or DFA.EMPTY_STRING not in set(
            patterns
        ), "Empty string not permitted for PDdfa type AND!"

        def compute_number_of_states():
            k = 1
            for x in patterns:
                k *= len(x) + 1
            return k

        patterns.sort(key=lambda s: -len(s))
        if patterns[-1] == DFA.EMPTY_STRING:
            patterns.pop()
            self.mark_start_state_as_accepting = True
        else:
            self.mark_start_state_as_accepting = False

        self.Q = compute_number_of_states()
        self.input_signs = input_signs
        self.patterns = patterns
        self.n = len(patterns)
        self.state_mapping = dict()
        self.type = _type

        self._compute_state_transitions_for_pdfa()
        self._mark_accepting_states_for_pdfa()

    def _compute_state_transitions_for_pdfa(self):

        def find_new_state(x, a):
            words = [self.patterns[i][: x[i]] + a for i in range(self.n)]
            state = []
            for i in range(self.n):
                prefixes = set(
                    [self.patterns[i][:j] for j in range(len(self.patterns[i]) + 1)]
                )
                suffixes = [words[i][j:] for j in range(len(words[i]) + 1)]
                for s in suffixes:
                    if s in prefixes:
                        state.append(len(s) % (len(self.patterns[i]) + 1))
                        break
            for i in range(self.n):
                if x[i] == len(self.patterns[i]):
                    state[i] = x[i]

            return self.state_mapping[tuple(state)]

        xs = [range(len(x) + 1) for x in self.patterns]
        nested_loop1, nested_loop2 = product(*xs), product(*xs)

        cnt = 0
        for x in nested_loop1:
            self.state_mapping[x] = cnt
            cnt += 1
        for x in nested_loop2:
            for a in self.input_signs:
                self.δ[(self.state_mapping[x], a)] = find_new_state(x, a)

    def _mark_accepting_states_for_pdfa(self):
        if self.mark_start_state_as_accepting:
            start_state = self.state_mapping[tuple([0 for _ in range(self.n)])]
            self.F.add(start_state)

        if self.type == DFA.AND_TYPE_PATTERN_DFA:
            state = [len(x) for x in self.patterns]
            accept_state = self.state_mapping[tuple(state)]
            self.F.add(accept_state)
        elif self.type == DFA.OR_TYPE_PATTERN_DFA:
            xs = [range(len(x) + 1) for x in self.patterns]
            nested_loop = product(*xs)
            for state in nested_loop:
                for i in range(self.n):
                    if state[i] == len(self.patterns[i]):
                        self.F.add(self.state_mapping[tuple(state)])
        else:
            assert False, "Wrong type of PatternDFA, 'AND' or 'OR' type allowed only!"

    def create_random_dfa(self, Q, input_signs):
        self.Q = Q
        self.input_signs = input_signs
        self.type = DFA.RANDOM_DFA

        self.δ.clear()
        self.F.clear()

        for q in range(self.Q):
            for a in self.input_signs:
                self.δ[(q, a)] = random.randint(0, self.Q - 1)
        # self.F = set(
        #     random.choices(
        #         population=range(self.Q), k=random.randint(0, (self.Q - 1) // 2)
        #     )
        # )
        accetp_state_rate = 0.1
        for q in range(self.Q):
            if random.random() <= accetp_state_rate:
                self.F.add(q)

    """
    Returns a random automaton that is indempotent due to transitions after the 'letter' character
    """

    def create_random_indempotent_automaton(self, Q, input_signs, letter="a"):
        assert letter in set(input_signs), "Letter must be in input_signs!"

        self.create_random_dfa(Q=Q, input_signs=input_signs)
        self.type = DFA.INDEMPOTENT
        self.indempotent_letter = letter
        states = [q for q in range(self.Q)]
        random.shuffle(states)

        while len(states) > 0:
            q1 = states.pop()
            q2 = states.pop() if len(states) > 0 else q1

            self.δ[(q1, letter)] = q2
            self.δ[(q2, letter)] = q2

    """
    Checks whether a given machine is indempotent due to the 'letter' character
    """

    def check_if_idempotent(self, letter="a"):
        for q1 in range(self.Q):
            q2 = self.δ[(q1, letter)]
            if self.δ[(q2, letter)] != q2:
                return False
        return True
