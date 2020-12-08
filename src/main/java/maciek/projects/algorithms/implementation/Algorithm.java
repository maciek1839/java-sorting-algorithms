package maciek.projects.algorithms.implementation;

public interface Algorithm {
    long showUsage();
    int[] sortData(int[] data) throws NullPointerException,IllegalArgumentException;
    int i_dataSize=100000;
    //we need to fix data's range, for example -100000000 to 100000000
    int i_maxRange=100000001;
}
