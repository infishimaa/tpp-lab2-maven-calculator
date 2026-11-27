package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class Application {

    private final CalculatorService calculatorService;

    public Application(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("expression", "");
        return "calculator";
    }

    @PostMapping("/")
    public String calculate(
            @RequestParam("expression") String expression,
            Model model) {

        model.addAttribute("expression", expression);

        try {
            String result = calculatorService.calculate(expression)
                    .stripTrailingZeros()
                    .toPlainString();

            model.addAttribute("result", result);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        }

        return "calculator";
    }
}