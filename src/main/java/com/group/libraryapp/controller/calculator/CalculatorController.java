package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.*;
import com.group.libraryapp.dto.calculator.response.CalculatorResultResponse;
import com.group.libraryapp.dto.calculator.response.DateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class CalculatorController {

    @GetMapping("/add")  // GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")  // POST /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculatorResultResponse result (CalculatorResultRequest request) {
        return new CalculatorResultResponse(request.getNumber1() + request.getNumber2()
                , request.getNumber1() - request.getNumber2()
                , request.getNumber1() * request.getNumber2());
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponse getDayOfTheWeek (DateRequest request) {
        String year  = request.getDate().split("-")[0];
        String month = request.getDate().split("-")[1];
        String day   = request.getDate().split("-")[2];

        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        return new DateResponse(date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
    }

    @PostMapping("/api/v1/sum")
    public int sum (@RequestBody NumbersRequest request) {
        int result = 0;
        for (int i = 0; i < request.getNumbers().size(); i++) {
            result += request.getNumbers().get(i);
        }
        return result;
    }
}
