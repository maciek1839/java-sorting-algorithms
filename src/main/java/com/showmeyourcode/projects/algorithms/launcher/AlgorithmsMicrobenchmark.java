package com.showmeyourcode.projects.algorithms.launcher;

import com.showmeyourcode.projects.algorithms.algorithm.AlgorithmDataGenerator;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.BubbleSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CocktailShakerSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.CountingSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.HeapSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.InsertionSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.MergeSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.QuickSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.SelectionSort;
import com.showmeyourcode.projects.algorithms.algorithm.implementation.ShellSort;
import com.showmeyourcode.projects.algorithms.benchmark.AlgorithmsBenchmarkData;
import com.showmeyourcode.projects.algorithms.benchmark.BenchmarkDataGenerator;
import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfigurationLoader;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.exception.CannotLoadAppPropertiesException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 * ======================== 10 000 ========================
 * Benchmark                                    Mode  Cnt   Score   Error  Units
 * AlgorithmsMicrobenchmark.bubbleSort          avgt   25   0.003 ± 0.001  ms/op
 * AlgorithmsMicrobenchmark.cocktailShakerSort  avgt   25   0.011 ± 0.001  ms/op
 * AlgorithmsMicrobenchmark.countingSort        avgt   25   0.343 ± 0.019  ms/op
 * AlgorithmsMicrobenchmark.heapSort            avgt   25   0.551 ± 0.023  ms/op
 * AlgorithmsMicrobenchmark.insertionSort       avgt   25   0.018 ± 0.005  ms/op
 * AlgorithmsMicrobenchmark.mergeSort           avgt   25   0.444 ± 0.014  ms/op
 * AlgorithmsMicrobenchmark.quickSort           avgt   25   0.092 ± 0.017  ms/op
 * AlgorithmsMicrobenchmark.selectionSort       avgt   25  22.552 ± 3.825  ms/op
 * AlgorithmsMicrobenchmark.shellSort           avgt   25   0.134 ± 0.015  ms/op
 *
 * Result "com.showmeyourcode.projects.algorithms.launcher.AlgorithmsMicrobenchmark.shellSort":
 * 0.134 ±(99.9%) 0.015 ms/op [Average]
 * (min, avg, max) = (0.109, 0.134, 0.190), stdev = 0.021
 * CI (99.9%): [0.118, 0.149] (assumes normal distribution)
 *
 * Run complete. Total time: 00:06:54
 *
 * ======================== 50 000 ========================
 * Benchmark                                    Mode  Cnt    Score     Error  Units
 * AlgorithmsMicrobenchmark.bubbleSort          avgt   25    0.016 ±   0.003  ms/op
 * AlgorithmsMicrobenchmark.cocktailShakerSort  avgt   25    0.051 ±   0.005  ms/op
 * AlgorithmsMicrobenchmark.countingSort        avgt   25    1.251 ±   0.136  ms/op
 * AlgorithmsMicrobenchmark.heapSort            avgt   25    3.929 ±   0.899  ms/op
 * AlgorithmsMicrobenchmark.insertionSort       avgt   25    0.092 ±   0.022  ms/op
 * AlgorithmsMicrobenchmark.mergeSort           avgt   25    4.509 ±   1.586  ms/op
 * AlgorithmsMicrobenchmark.quickSort           avgt   25    0.683 ±   0.019  ms/op
 * AlgorithmsMicrobenchmark.selectionSort       avgt   25  727.457 ± 151.299  ms/op
 * AlgorithmsMicrobenchmark.shellSort           avgt   25    0.691 ±   0.065  ms/op
 *
 *
 * Result "com.showmeyourcode.projects.algorithms.launcher.AlgorithmsMicrobenchmark.selectionSort":
 * 727.457 ±(99.9%) 151.299 ms/op [Average]
 * (min, avg, max) = (481.318, 727.457, 1160.626), stdev = 201.979
 * CI (99.9%): [576.159, 878.756] (assumes normal distribution)
 *
 * Run complete. Total time: 00:07:29
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(5)
@State(Scope.Benchmark)
public class AlgorithmsMicrobenchmark {

    private int[] loadedData;
    private AlgorithmDataGenerator dataGenerator;

    @Setup
    public void setup() throws BenchmarkDataNotFoundException, IOException, CannotLoadAppPropertiesException {
        var appConfiguration = new SortingAppConfigurationLoader(SortingAlgorithmsApplication.DEFAULT_PROPERTIES_FILE).getConfig();
        dataGenerator = new AlgorithmDataGenerator(appConfiguration);

        var benchmarkDataGenerator = new BenchmarkDataGenerator(appConfiguration);
        // here you can change dataset size
        loadedData = benchmarkDataGenerator.loadData(AlgorithmsBenchmarkData.TEN_THOUSANDS);
    }

    @Benchmark
    public int[] bubbleSort() {
        return new BubbleSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] cocktailShakerSort() {
        return new CocktailShakerSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] countingSort() {
        return new CountingSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] heapSort() {
        return new HeapSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] insertionSort() {
        return new InsertionSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] mergeSort() {
        return new MergeSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] quickSort() {
        return new QuickSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] selectionSort() {
        return new SelectionSort(dataGenerator).sortData(loadedData);
    }

    @Benchmark
    public int[] shellSort() {
        return new ShellSort(dataGenerator).sortData(loadedData);
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/sorting-demo-*.jar AlgorithmsMicrobenchmark
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + AlgorithmsMicrobenchmark.class.getSimpleName() + ".*")
                .build();

        new Runner(opt).run();
    }
}
