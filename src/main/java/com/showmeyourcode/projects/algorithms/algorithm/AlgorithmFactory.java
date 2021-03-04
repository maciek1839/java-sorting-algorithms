package com.showmeyourcode.projects.algorithms.algorithm;

import java.util.List;

public interface AlgorithmFactory {
    Algorithm createAlgorithm(AlgorithmType enumVal);

    List<Algorithm> creatAllAvailableAlgorithms();
}
