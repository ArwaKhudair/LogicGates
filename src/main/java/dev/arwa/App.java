
package dev.arwa;

import java.util.Scanner;

/**
 * @author Arwa
 * @version 1.0
 * @since 2023-03-23
 *
 */
// This is a program that performs logical operations
// and prints the result truth table in the console
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the Logical Operations Program");
        System.out.println("========================================");
        int operator = pickOperator();
        System.out.println("You picked " + operatorChar(operator) + " - " + description(operator));
        System.out.println("========================================");
        System.out.println("Truth Table");
        System.out.println("========================================");
        System.out.println("A\t" + operatorChar(operator) + "\tB\tResult");
        System.out.println("========================================");
        System.out.println("F\t" + operatorChar(operator) + "\tF\t" + performOperation(false, operator, false));
        System.out.println("F\t" + operatorChar(operator) + "\tT\t" + performOperation(false, operator, true));
        System.out.println("T\t" + operatorChar(operator) + "\tF\t" + performOperation(true, operator, false));
        System.out.println("T\t" + operatorChar(operator) + "\tT\t" + performOperation(true, operator, true));
        System.out.println("========================================");
        
    }

    public static int pickOperator() {
        System.out.println("Pick an operator:");
        System.out.println("1. AND");
        System.out.println("2. OR");
        System.out.println("3. XOR");
        System.out.println("4. Implication");
        System.out.println("5. Biconditional");

        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        scanner.close();
        return res;
    }

    public static boolean performOperation(boolean a, int operator, boolean b) {
        boolean result = false;
        switch (operator) {
            case 1:
                result = a && b;
                break;
            case 2:
                result = a || b;
                break;
            case 3:
                result = a ^ b;
                break;
            case 4:
                result = !a || b;
            case 5:
                result = (!a || b) && (a || !b);
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        return result;
    }

    public static String operatorChar(int operator) {
        switch (operator) {
            case 1:
                return "^";
            case 2:
                return "v";
            case 3:
                return "XOR";
            case 4:
                return "->";
            case 5:
                return "<->";
            default:
                return "Invalid operator";
        }
    }

    public static String description(int operator) {
        switch (operator) {
            case 1:
                return "Both operands are must be true";
            case 2:
                return "One of the operands must be true";
            case 3:
                return "One of the operands must be true but not both";
            case 4:
                return "If the first operand is false, the second operand must be true | ~a v b";
            case 5:
                return "If the first operand is false, the second operand must be true and vice versa | (~a v b) ^ (a v ~b)";
            default:
                return "Invalid operator";
        }   
    }   
}   
