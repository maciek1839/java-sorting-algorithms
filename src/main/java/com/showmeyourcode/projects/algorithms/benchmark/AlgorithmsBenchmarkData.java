package com.showmeyourcode.projects.algorithms.benchmark;

public enum AlgorithmsBenchmarkData implements BenchmarkData {
    FIFTY_THOUSANDS("benchmark/50000.txt", 50000),
    ONE_HUNDRED_THOUSAND("benchmark/100000.txt", 100000),
    ONE_HUNDRED_FIFTY_THOUSAND("benchmark/150000.txt", 150000);

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
