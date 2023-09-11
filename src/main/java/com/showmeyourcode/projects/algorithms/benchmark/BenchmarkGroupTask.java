package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.algorithm.Algorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RecursiveTask;

@Slf4j
@RequiredArgsConstructor
public class BenchmarkGroupTask extends RecursiveTask<BenchmarkResultGroup> {

    private final int[] unsortedData;
    private final transient BenchmarkData benchmarkData;
    private final transient List<Algorithm> algorithms;

    public String getGroupId(){
        return "GroupId-"+benchmarkData.getSize();
    }

    @Override
    protected BenchmarkResultGroup compute() {
        BenchmarkResultGroup group = new BenchmarkResultGroup(benchmarkData);
        var tasks = new ArrayList<BenchmarkGroupSubTask>();

        for (Algorithm algorithm : algorithms) {
            var task = new BenchmarkGroupSubTask(
                    Arrays.copyOf(unsortedData,unsortedData.length),
                    benchmarkData,
                    algorithm
            );
            task.fork();
            tasks.add(task);
        }

        tasks.forEach(t-> {
                    log.debug("[{}] Getting partialResults from: {}", getGroupId(), t.getSubgroupId());
                    group.getResults().add(t.join());
                    log.debug("[{}] Got partialResults from: {}", getGroupId(), t.getSubgroupId());
                });

        return group;
    }
}
