package com.showmeyourcode.projects.algorithms.algorithm;

import lombok.Getter;

public interface Algorithm {

    long showUsage();

    int[] sortData(int[] data);

    AlgorithmType getType();

    AlgorithmMetadata getMetadata();

    @Getter
    class AlgorithmMetadata {
        private final String averageComplexity;
        private final String inPlace;
        private final String nameInMarkdownFormat;
        private final String stable;
        private final String theBestComplexity;
        private final String theWorstSpaceComplexity;
        private final String worstComplexity;

        public AlgorithmMetadata(String nameInMarkdownFormat,
                                 String theBestComplexity,
                                 String averageComplexity,
                                 String worstComplexity,
                                 String theWorstSpaceComplexity,
                                 String stable,
                                 String inPlace) {
            this.averageComplexity = averageComplexity;
            this.inPlace = inPlace;
            this.nameInMarkdownFormat = nameInMarkdownFormat;
            this.stable = stable;
            this.theBestComplexity = theBestComplexity;
            this.theWorstSpaceComplexity = theWorstSpaceComplexity;
            this.worstComplexity = worstComplexity;
        }
    }
}
