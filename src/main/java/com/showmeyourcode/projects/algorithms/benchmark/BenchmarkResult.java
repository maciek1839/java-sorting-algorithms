package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;

public record BenchmarkResult(AlgorithmType algorithmType,
                              int datasetSize,
                              long timeElapsedInNanoSeconds,
                              Algorithm.AlgorithmMetadata metadata) {
}
