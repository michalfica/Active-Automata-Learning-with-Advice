import subprocess

"""
Class that is used to communicate with LearnLib repository.
Allows to:
    * compile LearLib repository,
    * run LearnLib implementation of L* or TTT algorithm,
    * returns the result of execution of the above algorithms and handles possible errors.
"""


class RunLearnLib:
    LSTAR_command = 'cd ../../../learnlib/examples ; mvn exec:java -q -Dexec.mainClass="de.learnlib.example.LstarExample1"'
    TTT_command = 'cd ../../../learnlib/examples ; mvn exec:java -q -Dexec.mainClass="de.learnlib.example.TTTExample1"'
    Lstar_Conv_WithCL_WithAdvice_command = 'cd ../../../learnlib/examples ; mvn exec:java -q -Dexec.mainClass="de.learnlib.example.LstarExample_conv_cl_withAS"'
    Lstar_Idem_WithAdvice_command = 'cd ../../../learnlib/examples ; mvn exec:java -q -Dexec.mainClass="de.learnlib.example.LstarExample_idenpotent_withAS"'
    TTT_Conv_WithAdvice_command = 'cd ../../../learnlib/examples ; mvn exec:java -q -Dexec.mainClass="de.learnlib.example.TTTExample1_withAS"'

    def __init__(self, debug=False):
        self.debug = debug

    def __runCommand(self, command):
        proc = subprocess.run([command], shell=True, capture_output=True, text=True)
        assert proc.returncode == 0, (
            "Error during execution of subprocess.run "
            + command
            + "\nstout: "
            + proc.stdout
            + "\nstderr: "
            + proc.stderr
        )
        return proc

    def compileLearnLib(self):
        c = "cd ../../../learnlib/examples ; mvn clean install"
        _ = self.__runCommand(c)

    def __getNumberofEQ(self, s):
        for l in s.splitlines():
            if l.startswith("Learning rounds"):
                return int(l.split()[-1])

    def _runAlgorithm(self, command):
        proc = self.__runCommand(command)
        mq, eq = "?", self.__getNumberofEQ(proc.stdout)
        return [mq, eq]

    def runLstar(self):
        return self._runAlgorithm(self.LSTAR_command)

    def runLstarConvWithCLWithAdvice(self):
        return self._runAlgorithm(self.Lstar_Conv_WithCL_WithAdvice_command)

    def runLstarIdemWithAdvice(self):
        return self._runAlgorithm(self.Lstar_Idem_WithAdvice_command)

    def runTTT(self):
        return self._runAlgorithm(self.TTT_command)

    def runTTTWithAdvice(self):
        return self._runAlgorithm(self.TTT_Conv_WithAdvice_command)
