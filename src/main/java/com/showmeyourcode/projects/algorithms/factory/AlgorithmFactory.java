package com.showmeyourcode.projects.algorithms.factory;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public interface AlgorithmFactory {
    Algorithm createAlgorithm(AlgorithmType enumVal);
}
