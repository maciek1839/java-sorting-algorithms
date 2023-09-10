package com.showmeyourcode.projects.algorithms.benchmark;

public enum AlgorithmsBenchmarkData implements BenchmarkData {
    TEN_THOUSAND("benchmark/10000.txt", 10_000),
    FIFTY_THOUSAND("benchmark/50000.txt", 50_000),
    ONE_HUNDRED_THOUSAND("benchmark/100000.txt", 100_000),
    ONE_HUNDRED_FIFTY_THOUSAND("benchmark/150000.txt", 150_000);

    private final String path;
    private final int size;

    AlgorithmsBenchmarkData(String path, int size) {
        this.path = path;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public int getSize() {
        return size;
    }
}
