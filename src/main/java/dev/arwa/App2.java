package dev.arwa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Arwa
 * @version 1.0
 * @since 2023-03-23
 *
 */
// This is a program that performs logical operations
// and prints the result truth table in the console

public class App2 {
    final static String AND = "^";
    final static String OR = "v";
    final static String XOR = "*";
    final static String IMPLICATION = ">";
    final static String BICONDITIONAL = "=";
    final static String Not = "~";

    public static void main(String[] args) {
        System.out.println("Welcome to the Logical Operations Program");
        System.out.println("Allowed variables are: Q, P, R, S");
        System.out.println("Allowed operators are: ^, v, XOR, ->, <->, ~");
        System.out.println("Example: ~P^Q->RvS");
        System.out.println("========================================");
        String expression = pickExpression();
        System.out.println("You picked " + expression);
        System.out.println("========================================");
        System.out.println("Truth Table");
        System.out.println("========================================");

        List<String> variables = getVariables(expression);
        List<Boolean> values = new ArrayList<>();
        // System.out.println("P\tQ\tR\tS\t" + expression);
        // System.out.println("========================================");
        // System.out.println("F\tF\tF\tF\t" + performOperation(false, expression,
        // false, false, false));
    }
    


    public static List<String> getVariables(String expression) {
        List<String> variables = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == 'P' || expression.charAt(i) == 'Q' || expression.charAt(i) == 'R'
                    || expression.charAt(i) == 'S') {
                variables.add("" + expression.charAt(i));
            }   
        }   
        return variables;
    }   

    public boolean getValue(String complex, List<String> variables, List<Boolean> values) {
        String operand = "" + complex.charAt(0);
        if (operand.equals(Not)) {
            LogicalOperand logicalOperand = new LogicalOperand("" + complex.charAt(1), true);
        } else if (operand.equals(AND)) {
            LogicalOperand logicalOperand = new LogicalOperand("" + complex.charAt(0), false);
        }   
        for (int i = 0; i < variables.size(); i++) {
            
            }   
    }   

    public int getOperator(String opertor) {
        switch (opertor) {
            case AND:
                return 1;
            case OR:
                return 2;
            case XOR:
                return 3;
            case IMPLICATION:
                return 4;
            case BICONDITIONAL:
                return 5;
            default:
                return 0;
        }
    }   

    public static String pickExpression() {
        System.out.println("Enter an expression:");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        res = res.toUpperCase();
        res.replace("XOR", "*");
        res.replace("->", ">");
        res.replace("<->", "=");
        res.replace("V", "v");
        res.replace(" ", "");
        scanner.close();
        return res;
    }

}

class LogicalOperand {
    private String operand; // P, Q, R, S
    private boolean isNegated; // ~
    private boolean value; // true or false

    public LogicalOperand(String operand, boolean isNegated) {
        this.operand = operand;
        this.isNegated = isNegated;
    }

    public void setValue(String operand, boolean newVal) {
        if (operand.equals(this.operand)) {
            if (isNegated) {
                this.value = !newVal;
            } else {
                this.value = newVal;
            }   
        }   
    }   

    public boolean getValue() {
        return this.value;
    }


}

