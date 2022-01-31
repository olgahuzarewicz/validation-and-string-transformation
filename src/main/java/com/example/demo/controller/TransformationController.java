package com.example.demo.controller;

import com.example.demo.model.Input;
import com.example.demo.model.Output;
import com.example.demo.service.TransformationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transformation")
public class TransformationController {

    TransformationService transformationService;

    public TransformationController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping
    public Output transformInput(@Valid @RequestBody Input input) {
        return this.transformationService.transform(input);
    }
}