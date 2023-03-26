package com.bbolzan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class TestBarca {

    @ParameterizedTest
    @CsvSource({
            "F62A01" /*Lugar com fileira não existente */,
            "F32A21" /*Lugar com numero de assento não existente */,
            "F61A21" /*Lugar com fileira e numero de assento não existentes */
    })
    void testaAssentoInvalido(String assento) {
        int rEsp = 0;
        int rObs = BarcaBugs.ocupaLugar(assento);
        Assertions.assertEquals(rEsp, rObs);
    }

}
