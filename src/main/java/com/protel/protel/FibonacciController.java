package com.protel.protel;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FibonacciController {

    @GetMapping("/fibonacci")
    public int fibonacci(@RequestParam int value){
        return fibonacciCalculator(value);
    }

    int fibonacciCalculator(int value){
        if (value <= 1)
            return value;
        return fibonacciCalculator(value-1) + fibonacciCalculator(value-2);
    }
}
