package com.showmeyourcode.projects.algorithms.algorithm;

import java.util.List;

public interface AbstractAlgorithmFactory {
    Algorithm createAlgorithm(AlgorithmType enumVal);

    List<Algorithm> creatAllAvailableAlgorithms();
}
