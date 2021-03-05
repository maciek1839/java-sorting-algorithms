package com.showmeyourcode.projects.algorithms.configuration;

import lombok.Data;
import lombok.NonNull;

@Data
public class SortingAppConfiguration {
    @NonNull
    private final int dataSize;
    @NonNull
    private final int maxRange;
}
