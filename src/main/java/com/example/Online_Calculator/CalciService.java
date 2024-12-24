package com.example.Online_Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalciService {

    public Double add(double num1,double num2){
        return num1+num2;
    }

    public Double sub(double num1,double num2){
        return num1-num2;
    }

    public Double mul(double num1,double num2){
        return num1*num2;
    }

    public Double div(double num1,double num2){
        return num1/num2;
    }

}
