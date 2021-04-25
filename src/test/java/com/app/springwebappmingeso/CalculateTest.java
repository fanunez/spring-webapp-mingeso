package com.app.springwebappmingeso;

import com.app.springwebappmingeso.models.Calculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {
    @Test
    @DisplayName("sipo1")
    public void calculateSum_twoNumbers_returnNumber() {
        Calculate calculate = new Calculate(1, 2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(3, calculate.getResult());
    }

    @Test
    @DisplayName("sipo2")
    public void calculateSum_oneNegativeNumber_returnNumber() {
        Calculate calculate = new Calculate(1, -2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(-1, calculate.getResult());
    }

    @Test
    @DisplayName("sipo3")
    public void calculateSum_twoNegativeNumbers_returnNumber() {
        Calculate calculate = new Calculate(-1, -2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(-3, calculate.getResult());
    }

}
