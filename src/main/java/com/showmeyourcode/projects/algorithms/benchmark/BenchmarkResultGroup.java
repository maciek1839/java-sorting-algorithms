package com.showmeyourcode.projects.algorithms.benchmark;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class BenchmarkResultGroup {
    private final BenchmarkData benchmarkData;
    private final List<BenchmarkResult> results;

    public BenchmarkResultGroup(BenchmarkData benchmarkData) {
        this.benchmarkData = benchmarkData;
        this.results = new ArrayList<>();
    }
}
