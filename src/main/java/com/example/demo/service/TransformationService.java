package com.example.demo.service;

import com.example.demo.model.Input;
import com.example.demo.model.Output;
import com.google.common.base.CaseFormat;
import org.joda.time.DateTimeUtils;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TransformationService {

    public Output transform(Input input){
        Set<String> b = input.getItems().stream()
                .map(s -> isSnakeCase(s) ? transformToCamelCase(s) : s)
                .collect(Collectors.toSet());
        return new Output(input.getName(), b, DateTimeUtils.currentTimeMillis());
    }

    private String transformToCamelCase(String s) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, s);
    }

    private boolean isSnakeCase(String s) {
        return Pattern.matches("([A-Za-z]*)_([A-Za-z]*)", s);
    }
}
