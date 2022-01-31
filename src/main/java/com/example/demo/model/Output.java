package com.example.demo.model;

import lombok.Value;
import java.util.Set;

@Value
public class Output {
    String name;
    Set<String> items;
    long timestamp;
}
