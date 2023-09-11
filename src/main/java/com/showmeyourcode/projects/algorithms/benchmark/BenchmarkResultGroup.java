package com.showmeyourcode.projects.algorithms.benchmark;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BenchmarkResultGroup {
    private final BenchmarkData benchmarkData;
    private final List<BenchmarkResult> results;

    public BenchmarkResultGroup(BenchmarkData benchmarkData) {
        this.benchmarkData = benchmarkData;
        this.results = new ArrayList<>();
    }
}
