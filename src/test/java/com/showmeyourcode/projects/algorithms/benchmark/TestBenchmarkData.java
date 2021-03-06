package com.showmeyourcode.projects.algorithms.benchmark;

public enum TestBenchmarkData implements BenchmarkData {
    BROKEN_BENCHMARK_DATA("benchmark/file-does-not-exist.txt", 100000);

    private final String path;
    private final int size;

    TestBenchmarkData(String path, int size) {
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
