package com.example.demo.model;

import com.example.demo.validation.NonStringConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class Input {

    @NotBlank(message = "Name may not be blank")
    String name;

    @NonStringConstraint
    List<String> items;
}
