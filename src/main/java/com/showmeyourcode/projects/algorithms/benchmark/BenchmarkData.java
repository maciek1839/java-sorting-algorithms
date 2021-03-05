package com.showmeyourcode.projects.algorithms.benchmark;

public enum BenchmarkData {
    TEN_THOUSANDS("benchmark/10000.txt", 10000),
    FIFTY_THOUSANDS("benchmark/50000.txt", 50000),
    ONE_HUNDRED_THOUSANDS("benchmark/100000.txt", 100000);

    private final String path;
    private final int size;

    BenchmarkData(String path, int size) {
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
