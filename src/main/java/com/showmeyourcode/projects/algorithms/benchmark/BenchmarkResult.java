package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BenchmarkResult {
    private final AlgorithmType algorithmType;
    private final int datasetSize;
    private final long timeElapsed;
}
