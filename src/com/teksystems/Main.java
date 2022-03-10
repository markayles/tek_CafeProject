package com.teksystems;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Product coffee = new Product("Coffee", "A coffee", 2.25f);
        Product espresso = new Product("Espresso", "An espresso", 3.65f);
        Product cappuccino = new Product("Cappuccino", "A cappuccino", 4.10f);

        Scanner scan = new Scanner(System.in);

        System.out.print("How many coffees would you like to order?: ");
        int coffeeOrderNum = scan.nextInt();

        System.out.print("How many espressos would you like to order?: ");
        int espressoOrderNum = scan.nextInt();

        System.out.print("How many cappuccinos would you like to order?: ");
        int cappuccinoOrderNum = scan.nextInt();

        double subTotal = 0;
        double salexTax = 0.06f;
        double finalTotal = 0;

        System.out.println("Total order");

        double coffeeSubTotal = coffee.getPrice() * coffeeOrderNum;
        subTotal += coffeeSubTotal;
        System.out.printf("%s - %s (Unit Price: $%.2f) Quantity: %d Subtotal: $%.2f\n", coffee.getName(), coffee.getDescription(), coffee.getPrice(), coffeeOrderNum, coffeeSubTotal);

        double espressoSubTotal = espresso.getPrice() * espressoOrderNum;
        subTotal += espressoSubTotal;
        System.out.printf("%s - %s (Unit Price: $%.2f) Quantity: %d Subtotal: $%.2f\n", espresso.getName(), espresso.getDescription(), espresso.getPrice(), espressoOrderNum, espressoSubTotal);

        double cappuccinoSubTotal = cappuccino.getPrice() * cappuccinoOrderNum;
        subTotal += espressoSubTotal;
        System.out.printf("%s - %s (Unit Price: $%.2f) Quantity: %d Subtotal: $%.2f\n", cappuccino.getName(), cappuccino.getDescription(), cappuccino.getPrice(), cappuccinoOrderNum, cappuccinoSubTotal);

        System.out.printf("Subtotal: $%.2f\n", subTotal);

        double taxTotal = subTotal * salexTax;
        System.out.printf("Tax: $%.2f\n", taxTotal);

        finalTotal = subTotal + taxTotal;
        System.out.printf("Sale Total: $%.2f\n", finalTotal);

    }
}
