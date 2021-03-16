package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BenchmarkResult {
    private final AlgorithmType algorithmType;
    private final int datasetSize;
    private final long memoryRuntimeDifference;
    private final long memoryUsedAtTheBeginningInBytes;
    private final long memoryUsedAtTheEndInBytes;
    private final long timeElapsedInNanoSeconds;

    public BenchmarkResult(AlgorithmType algorithmType,
                           int datasetSize,
                           long timeElapsedInNanoSeconds,
                           long memoryUsedAtTheBeginningInBytes,
                           long memoryUsedAtTheEndInBytes) {
        this.algorithmType = algorithmType;
        this.datasetSize = datasetSize;
        this.timeElapsedInNanoSeconds = timeElapsedInNanoSeconds;
        this.memoryUsedAtTheBeginningInBytes = memoryUsedAtTheBeginningInBytes;
        this.memoryUsedAtTheEndInBytes = memoryUsedAtTheEndInBytes;
        this.memoryRuntimeDifference = memoryUsedAtTheEndInBytes - memoryUsedAtTheBeginningInBytes;
    }
}
