package com.showmeyourcode.projects.algorithms.benchmark;

import com.showmeyourcode.projects.algorithms.configuration.SortingAppConfiguration;
import com.showmeyourcode.projects.algorithms.exception.BenchmarkDataNotFoundException;
import com.showmeyourcode.projects.algorithms.generator.BaseDataGenerator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.util.Arrays;
import java.util.Objects;

public class BenchmarkDataGenerator extends BaseDataGenerator {

    public BenchmarkDataGenerator(SortingAppConfiguration appConfiguration) {
        super(appConfiguration);
    }

    public int[] loadData(BenchmarkData benchmarkData) throws BenchmarkDataNotFoundException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(benchmarkData.getPath());

        if (Objects.isNull(inputStream)) {
            throw new BenchmarkDataNotFoundException(benchmarkData);
        } else {
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

    public void generateNewDataset(int datasetSize) throws IOException {
        final String newDatasetPath = String.format("src/main/resources/benchmark/%d.txt", datasetSize);
        final File newDatasetFile = new File(newDatasetPath);
        if (!newDatasetFile.createNewFile()) {
            throw new FileAlreadyExistsException("A dataset already exists! Path: " + newDatasetPath);
        }

        final int[] datasetContent = generateIntData(datasetSize, 10000);

        try (OutputStream outStream = new FileOutputStream(newDatasetFile)) {
            String datasetAsString = Arrays.toString(datasetContent);
            outStream.write(datasetAsString.substring(1, datasetAsString.length() - 1).getBytes(StandardCharsets.UTF_8));
        }
    }
}
