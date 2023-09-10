package com.showmeyourcode.projects.algorithms.configuration;

import java.util.List;

public record SortingAppConfiguration(
        int dataSize,
        int maxRange,
        int defaultGeneratedDatasetSize,
        String benchmarkResultsFile,
        List<Integer> datasetSizesForBenchmark
) {
}
