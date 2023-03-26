package com.bbolzan;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Unit test for simple App.
 */
public class TestBarca {
    private BarcaBugs barca = null;

    @BeforeEach
    void setUp() {
        barca = new BarcaBugs();
    }

    @ParameterizedTest
    @CsvSource({
        "F05A19" , /*Resultado esperado = true */
        "F21A19" , /*Resultado esperado = false */
        "F10A50"   /*Resultado esperado = false */
    })

    void testGrupoA(String assento) {
        int rEsp = 3;
        int rObs = barca.ocupaLugar(assento);
        Assertions.assertEquals(rEsp, rObs);
    }

    @ParameterizedTest
    @CsvSource({
        "F30A01" /*Resultado esperado = true */,
        "F01A01" /*Resultado esperado = false */,
        "F99A99" /*Resultado esperado = false */

    })

    void testGrupoB(String assento) {
        int rEsp = 3;
        preenche100Lugares();
        int rObs = barca.ocupaLugar(assento);
        Assertions.assertEquals(rEsp, rObs);
    }
    
    @ParameterizedTest
    @CsvSource({
        "F61A22" /*Resultado esperado = false */,
        "F05A19" /*Resultado esperado = false */,
        "F60a01" /*Resultado esperado = true */
    })
     
    void testGrupoC(String assento) {
        int rEsp = 3;
        int rObs = barca.ocupaLugar(assento);
        preenche100Lugares();
        preenche100Lugares();
        Assertions.assertEquals(rEsp, rObs);
    }
    

    protected void preenche100Lugares() {
        int filas = 5;
        int assentos = 20;
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= assentos; j++) {
                String filasStr = Integer.toString(i);
                String assentosStr = Integer.toString(j);
                if (j < 10) {
                    assentosStr = "0" + assentosStr;
                }
                String resultado = "F0" + filasStr + "A" + assentosStr;
                barca.ocupaLugar(resultado);
            }
        }
    } 
}
