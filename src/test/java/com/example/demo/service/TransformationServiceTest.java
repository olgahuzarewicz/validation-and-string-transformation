package com.example.demo.service;

import com.example.demo.model.Input;
import com.example.demo.model.Output;
import org.joda.time.DateTimeUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransformationServiceTest {

    @InjectMocks
    TransformationService service;

    @BeforeAll
    public static void init() throws ParseException {
        SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
        Date fixedDateTime = DATE_FORMATTER.parse("01/07/2016 16:45:00:000");
        DateTimeUtils.setCurrentMillisFixed(fixedDateTime.getTime());
    }

    @AfterAll
    public static void after() {
        DateTimeUtils.setCurrentMillisSystem();
    }

    @ParameterizedTest
    @MethodSource("provideInputs")
    void testTransform(Input input, Output expected) {
        Output output = this.service.transform(input);

        assertEquals(expected, output);
    }

    private static Stream<Arguments> provideInputs() {
        return Stream.of(
                Arguments.of(new Input("name", List.of()), new Output("name", Set.of(), DateTimeUtils.currentTimeMillis())),
                Arguments.of(new Input("name", List.of("aa_bb")), new Output("name", Set.of("AaBb"), DateTimeUtils.currentTimeMillis())),
                Arguments.of(new Input("name", List.of("aa", "aa")), new Output("name", Set.of("aa"), DateTimeUtils.currentTimeMillis())),
                Arguments.of(new Input("name", List.of("ABC", "Aa_bb", "Aa_bb")), new Output("name", Set.of("ABC", "AaBb"), DateTimeUtils.currentTimeMillis()))
        );
    }



}