package com.app.springwebappmingeso;

import com.app.springwebappmingeso.models.Calculate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class modelTest {
    @Test
    void modelCreationTest() {
        Calculate test = new Calculate(1, 1, 2);
        test.setNumber1(2);
        assertEquals(test.getNumber1(), 2);
        test.setNumber2(3);
        assertEquals(test.getNumber2(), 3);
        test.setResult(5);
        assertEquals(test.getResult(), 5);
    }
}
