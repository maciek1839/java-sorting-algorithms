package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

@Slf4j
@RequiredArgsConstructor
public class BenchmarkGroupSubTask extends RecursiveTask<BenchmarkResult> {

    private final int[] unsortedData;
    private final transient BenchmarkData benchmarkData;
    private final transient Algorithm algorithm;

    public String getSubgroupId(){
        return String.format(
                "SubgroupId-%d-%s",
                benchmarkData.getSize(),
                algorithm
        );
    }

    @Override
    protected BenchmarkResult compute() {
        final long memoryBefore = ThreadUtil.getCurrentUsedMemoryInBytes();

        long start = System.nanoTime();
        algorithm.sortData(unsortedData);
        long finish = System.nanoTime();

        long elapsedNanos = finish - start;
        long memoryAfter = ThreadUtil.getCurrentUsedMemoryInBytes();

        log.debug("\n[{}/{}] Finished subtask. Memory before/after (MB): {}/{} Execution time (ms): {}",
                algorithm,
                benchmarkData.getSize(),
                ThreadUtil.convertBytesToMegaBytes(memoryBefore),
                ThreadUtil.convertBytesToMegaBytes(memoryAfter),
                ThreadUtil.convertNsToMs(elapsedNanos)
        );

        return new BenchmarkResult(
                        algorithm.getType(),
                        benchmarkData.getSize(),
                        elapsedNanos,
                        algorithm.getMetadata()
        );
    }
}
