# Active-Automata-Learning-with-Advice

We present the empirical evaluation of the active learning algorithm with advice.

This repository includes a custom implementation of L<sup>*</sup> algorithm with an advice system as well as an implementation built on top of a state-of-the-art automata learning library **learnlib**, which is open source. In the latter case, we have only implemented inferring answers to equivalence queries.

Files with cunducted expermients and summerized results can be found in *test_algorithm/Lstar* directory. 

In order to incorporate changes made in the learnlib repository, it is necessary to run the **apply-learnlib-patch.sh** script.
