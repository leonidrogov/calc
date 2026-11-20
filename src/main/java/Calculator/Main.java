package Calculator;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//@SuppressWarnings("PMD.SystemPrintln")
public class Main {
    public static void main(String[] args) {
        System.out.println("Print the expression: ");
        String expression = "";
        try(Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)){
            expression = scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            System.err.println("Error: no input line was found.");
        } catch (IllegalStateException e){
            System.err.println("Error: input scanner is closed.");
        }

        if (expression.isEmpty()) {
            System.err.println("Error: empty input.");
            return;
        }
        List<String> rpn = Calculator.toReversePolishNotation(expression);
        String rpnStr = String.join(" ", rpn);

        double result = Calculator.evaluate(expression);

        System.out.println("Expression: " + expression);
        System.out.println("RPN: " + rpnStr);
        System.out.println("Result: " + result);
    }
}
