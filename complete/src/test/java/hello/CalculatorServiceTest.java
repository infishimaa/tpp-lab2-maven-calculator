package hello;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceTest {

    private final CalculatorService calculator =
            new CalculatorService();

    @Test
    void additionShouldReturnTwo() {
        assertEquals(
                new BigDecimal("2"),
                calculator.calculate("1+1").stripTrailingZeros()
        );
    }

    /*
    @Test
    void subtractionIntentionallyWrong() {
        assertEquals(
                new BigDecimal("2"),
                calculator.calculate("5-1").stripTrailingZeros()
        );
    }
    */
}