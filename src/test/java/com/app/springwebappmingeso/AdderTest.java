package com.app.springwebappmingeso;

import com.app.springwebappmingeso.models.Adder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdderTest {
    @Test
    @DisplayName("sipo1")
    public void calculateSum_twoNumbers_returnNumber() {
        Adder adder = new Adder(1, 2, null);
        Integer result = adder.calculateSum(adder.getNumber1(), adder.getNumber2());
        adder.setResult(result);
        assertEquals(3, adder.getResult());
    }

    @Test
    @DisplayName("sipo2")
    public void calculateSum_oneNegativeNumber_returnNumber() {
        Adder adder = new Adder(1, -2, null);
        Integer result = adder.calculateSum(adder.getNumber1(), adder.getNumber2());
        adder.setResult(result);
        assertEquals(-1, adder.getResult());
    }

    @Test
    @DisplayName("sipo3")
    public void calculateSum_twoNegativeNumbers_returnNumber() {
        Adder adder = new Adder(-1, -2, null);
        Integer result = adder.calculateSum(adder.getNumber1(), adder.getNumber2());
        adder.setResult(result);
        assertEquals(-3, adder.getResult());
    }

}
