package com.app.springwebappmingeso;

import com.app.springwebappmingeso.models.Calculate;
import com.app.springwebappmingeso.services.CalculateService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {
    @Test
    void calculateSum_twoNumbers_returnNumber() {
        Calculate calculate = new Calculate(1, 2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(3, calculate.getResult());
    }

    @Test
    void calculateSum_oneNegativeNumber_returnNumber() {
        Calculate calculate = new Calculate(1, -2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(-1, calculate.getResult());
    }

    @Test
    void calculateSum_twoNegativeNumbers_returnNumber() {
        Calculate calculate = new Calculate(-1, -2, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(-3, calculate.getResult());
    }
    @Test
    void calculateSum_oneNumber_returnNumber() {
        Calculate calculate = new Calculate(-1, 0, null);
        Integer result = calculate.calculateSum(calculate.getNumber1(), calculate.getNumber2());
        calculate.setResult(result);
        assertEquals(-1, calculate.getResult());
    }

    @Test
    void calculateSum_returnOK() {
        Calculate calculate = new Calculate(1, 7, null);
        Gson gson = new Gson();
        String json = gson.toJson(calculate);
        CalculateService calculateService = new CalculateService();
        ResponseEntity<String> result = calculateService.calculateSum(json);
        String result1 = result.getBody();
        String result2 = "{\n  \"number1\": 1,\n  \"number2\": 7,\n  \"result\": 8\n}";
        assertEquals(result1, result2);
    }
    @Test
    void calculateSub_returnOK() {
        Calculate calculate = new Calculate(1, 7, null);
        Gson gson = new Gson();
        String json = gson.toJson(calculate);
        CalculateService calculateService = new CalculateService();
        ResponseEntity<String> result = calculateService.calculateSub(json);
        String result1 = result.getBody();
        String result2 = "{\n  \"number1\": 1,\n  \"number2\": 7,\n  \"result\": -6\n}";
        assertEquals(result1, result2);
    }
    @Test
    void calculateSum_twoNegatives_returnOK() {
        Calculate calculate = new Calculate(-1, -7, null);
        Gson gson = new Gson();
        String json = gson.toJson(calculate);
        CalculateService calculateService = new CalculateService();
        ResponseEntity<String> result = calculateService.calculateSum(json);
        String result1 = result.getBody();
        String result2 = "{\n  \"number1\": -1,\n  \"number2\": -7,\n  \"result\": -8\n}";
        assertEquals(result1, result2);
    }
    @Test
    void calculateSub_twoNegatives_returnOK() {
        Calculate calculate = new Calculate(-1, -7, null);
        Gson gson = new Gson();
        String json = gson.toJson(calculate);
        CalculateService calculateService = new CalculateService();
        ResponseEntity<String> result = calculateService.calculateSub(json);
        String result1 = result.getBody();
        String result2 = "{\n  \"number1\": -1,\n  \"number2\": -7,\n  \"result\": 6\n}";
        assertEquals(result1, result2);
    }
}
