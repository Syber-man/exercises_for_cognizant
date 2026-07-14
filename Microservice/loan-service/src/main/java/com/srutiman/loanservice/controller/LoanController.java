package com.srutiman.loanservice.controller;

import com.srutiman.loanservice.model.Loan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoan(@PathVariable String number) {

        return new Loan(
                number,
                "Home Loan",
                2500000
        );
    }
}