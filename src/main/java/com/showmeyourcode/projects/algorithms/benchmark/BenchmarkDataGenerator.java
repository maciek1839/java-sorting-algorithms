package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.generator.BaseDataGenerator;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BenchmarkDataGenerator extends BaseDataGenerator {

    public BenchmarkDataGenerator(SortingAppConfiguration appConfiguration) {
        super(appConfiguration);
    }

    public int[] loadData(BenchmarkData benchmarkData) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(benchmarkData.getPath());

        BufferedInputStream bis = new BufferedInputStream(inputStream);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        for (int result = bis.read(); result != -1; result = bis.read()) {
            buf.write((byte) result);
        }
        return Arrays.stream(buf.toString(StandardCharsets.UTF_8).split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .mapToInt(i -> i).toArray();
    }


}
