package com.example.junit;

public class ExceptionThrower {

    public void throwException(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
    }
}
