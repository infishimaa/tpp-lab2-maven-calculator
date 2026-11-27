package hello;

import java.math.BigDecimal;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.parser.ParseException;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public BigDecimal calculate(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException(
                    "Введіть математичний вираз."
            );
        }

        try {
            return new Expression(expression)
                    .evaluate()
                    .getNumberValue();
        } catch (EvaluationException | ParseException e) {
            throw new IllegalArgumentException(
                    "Не вдалося обчислити вираз. Перевірте його правильність.",
                    e
            );
        }
    }
}