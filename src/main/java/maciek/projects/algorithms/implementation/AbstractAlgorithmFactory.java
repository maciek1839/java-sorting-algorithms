package maciek.projects.algorithms.implementation;

public interface AbstractAlgorithmFactory {
    Algorithm createAlgorithm(Algorithms enumVal);
    String givePerformance(Algorithm algorithmVal);
}
