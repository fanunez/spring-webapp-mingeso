package com.app.springwebappmingeso.models;

public class Adder {
    private Integer number1;
    private Integer number2;
    private Integer result;

    public Adder(Integer number1, Integer number2, Integer result) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer calculateSum(Integer number1, Integer number2){
        Integer result = number1 + number2;
        return result;
    }
}
