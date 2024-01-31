package View;

import Common.Validation;
import Model.BMICalculator;
import Model.NormalCalculator;
import Model.Operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ComputerView {
    Scanner sc = new Scanner(System.in);
    Validation vd = new Validation();

    public double calculate(double a, Operator operator, double b) {
        double memory = 0;
        switch (operator) {
            case add:
                memory = a + b;
                break;
            case sub:
                memory = a - b;
                break;
            case mul:
                memory = a * b;
                break;
            case div:
                if (b == 0)
                    throw new ArithmeticException();
                memory = a / b;
                break;
            case exponent:
                memory = Math.pow(a,b);
                break;
        }
        return memory;
    }

    public void doNormalCalculator(NormalCalculator nc) {
        double memory = nc.getMemory();
        System.out.println("----- Normal Calculator -----");
        do {
            try {
                System.out.print("Enter number: ");
                double a = vd.checkin(sc.nextLine());
                while (true) {
                    try {
                        System.out.print("Enter Operator: ");
                        Operator operator = vd.checkOperator(sc.nextLine());
                        if (operator.equals(Operator.equals)) {
                            nc.setMemory(memory);
                            System.out.println("Result: " + new DecimalFormat("#.##").format(nc.getMemory()));
                            break;
                        } else {
                            System.out.print("Enter number: ");
                            double b = vd.checkin(sc.nextLine());
                            memory = calculate(a, operator, b);
                            System.out.println("Memory: " + new DecimalFormat("#.##").format(memory));
                            a = memory;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Please input (+, -, *, /, ^)");
                    } catch (ArithmeticException e) {
                        System.out.println("Can't divided into 0");
                    }
                }
                break;
            } catch (NullPointerException e) {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        } while (true);
    }

    public void doCalculateBMI(BMICalculator bc) {
        System.out.println("----- BMI Calculator -----");
        try {
            System.out.print("Enter weight in kg: ");
            double weight = vd.checkin(sc.nextLine());
            System.out.print("Enter height in cm: ");
            double height = vd.checkin(sc.nextLine());
            calculateBMI(weight, height, bc);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void calculateBMI(double weight, double height, BMICalculator bc) {
        bc = new BMICalculator(weight, height);
        bc.setBmiNumber();
        double bmi = bc.getBmiNumber();
        System.out.println("BMI number: " + new DecimalFormat("#.##").format(bmi));
        if (bmi < 19)
            System.out.println("UNDER-STANDARD");
        else if (bmi < 25)
            System.out.println("STANDARD");
        else if (bmi < 30)
            System.out.println("OVERWEIGHT");
        else if (bmi < 40)
            System.out.println("FAT - SHOULD LOSE WEIGHT");
        else
            System.out.println("VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY");
    }
}
