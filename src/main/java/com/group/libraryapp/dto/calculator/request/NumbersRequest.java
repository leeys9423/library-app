package com.group.libraryapp.dto.calculator.request;

import java.util.List;

public class NumbersRequest {
    private List<Integer> numbers;

    public NumbersRequest() {
    }

    public NumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
