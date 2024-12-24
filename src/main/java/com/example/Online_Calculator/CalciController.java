package com.example.Online_Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalciController {

    @Autowired
    CalciService service;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/calculate")
    public String performOperation(@RequestParam("num1") double num1,
                                   @RequestParam("num2") double num2,
                                   @RequestParam("operation") String opt,
                                   Model model) {
        double res;
        switch (opt) {
            case "add" -> res = service.add(num1, num2);
            case "sub" -> res = service.sub(num1, num2);
            case "mul" -> res = service.mul(num1, num2);
            case "div" -> {
                if (num2 == 0) {
                    model.addAttribute("errMsg", "Cannot divide by zero");
                    return "result";
                }
                res = service.div(num1, num2);
            }
            default -> {
                model.addAttribute("errMsg", "Invalid operation");
                return "result";
            }
        }
        model.addAttribute("res", res);
        model.addAttribute("operation", opt);
        return "result";
    }
}
