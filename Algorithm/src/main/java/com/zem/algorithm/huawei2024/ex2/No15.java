package com.zem.algorithm.huawei2024.ex2;

import java.util.Scanner;
import java.util.Stack;

/**
 * 1 + 5 * 7 / 8
 */
public class No15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String express = sc.nextLine();
        sc.close();

        try {
            Fraction fraction = calcuate(express);
            System.out.println(fraction);
        } catch (ArithmeticException e) {
            System.out.println("ERROR");
        }

    }

    private static Fraction calcuate(String express) {

        Stack<Fraction> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < express.length(); i++) {
            char c = express.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < express.length() && Character.isDigit(express.charAt(j))) {
                    j++;
                }
                Fraction number = new Fraction(Integer.parseInt(express.substring(i, j )), 1);
                numbers.push(number);
                i = j - 1;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    calcuate(numbers, operators);
                }
                operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    calcuate(numbers, operators);
                }
                operators.add(c);
            }
        }
        while (!operators.isEmpty()) {
            calcuate(numbers, operators);
        }
        return numbers.pop();
    }

    private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static void calcuate(Stack<Fraction> numbers, Stack<Character> operators) {
        Fraction b = numbers.pop();
        Fraction a = numbers.pop();

        Character op = operators.pop();

        switch (op) {
            case '+':
                numbers.push(a.add(b));
                break;
            case '-':
                numbers.push(a.sub(b));
                break;
            case '*':
                numbers.push(a.multiply(b));
                break;
            case '/':
                numbers.push(a.divide(b));
                break;
        }

    }

    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            if (denominator == 0) {
                throw new ArithmeticException();
            }
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));

            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            if (denominator < 0) {
                this.numerator = -this.numerator;
                this.denominator = -this.denominator;
            }
        }

        public Fraction add(Fraction other) {
            return new Fraction(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator);
        }

        public Fraction sub(Fraction other) {
            return new Fraction(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator);
        }

        public Fraction multiply(Fraction other) {
            return new Fraction(numerator * other.numerator, denominator * other.denominator);
        }

        public Fraction divide(Fraction other) {
            return new Fraction(numerator * other.denominator, denominator * other.numerator);

        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        @Override
        public String toString() {
            if (denominator == 1) {
                return String.valueOf(denominator);
            } else {
                return numerator + "/" + denominator;
            }
        }
    }
}
