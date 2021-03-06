package com.showmeyourcode.projects.algorithms.exception;

import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkData;

public class BenchmarkDataNotFoundException extends Exception {
    public BenchmarkDataNotFoundException(BenchmarkData benchmarkData) {
        super("A Benchmark data does not exist! Benchmark: " + benchmarkData.getPath());
    }
}
