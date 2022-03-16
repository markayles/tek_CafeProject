package com.teksystems.Project3;

import java.util.ArrayList;
import java.util.Scanner;

public class Store
{
    private Scanner scanner = new Scanner(System.in);
    ArrayList<Product> productsForSale = new ArrayList<>();

    public Store()
    {
        productsForSale.add(new Coffee("Coffee", "A hot cup of coffee.", 3.49f, false, false));
        productsForSale.add(new Espresso("Espresso", "An espresso.", 3.99f, false, false));
        productsForSale.add(new Cappuccino("Cappuccino", "A cappuccino.", 4.99f, false, false));
    }

    public void startShopping()
    {
        boolean shopping = true;
        boolean invalidResponse = false;
        ShoppingCart cart = new ShoppingCart(productsForSale);

        while (shopping)
        {
            if (invalidResponse)
            {
                System.out.println("Invalid response. Please try again.");
                invalidResponse = false;
            }

            int userSelected = showOptionMenu();

            if (userSelected == -1)
            {
                invalidResponse = true;
            }
            else if (userSelected == productsForSale.size() + 1)
            {
                shopping = false;
                System.out.println("Proceed to checkout.");
                checkout(cart);
            }
            else
            {
                productBuy(userSelected - 1); //-1 to account for 0 based index
            }
        }
    }

    private int showOptionMenu()
    {
        System.out.println("Please select from the following menu:");
        for (int i = 1; i <= productsForSale.size(); i++)
        {
            System.out.printf("%d: %s%n", i, productsForSale.get(i - 1).getName());
        }
        System.out.printf("%d: %s%n", productsForSale.size()+1, "Checkout");

        String userResponse = scanner.nextLine();
        int responseNum = -1;

        try
        {
            responseNum = Integer.parseInt(userResponse);
        } catch (NumberFormatException e)
        {
            return -1;
        }

        if (responseNum <= 0 || responseNum > productsForSale.size() + 1)
        {
            return -1;
        }

        return responseNum;
    }

    private void productBuy(int product)
    {
        Product p = productsForSale.get(product);
        System.out.printf("How many %s ($%.2f) would you like to purchase?%n", p.getName(), p.getPrice());

        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();

        if (purchaseAmount < 1)
        {
            System.out.println("Please enter a valid amount next time.");
        }
        else
        {
            p.setQuantity(purchaseAmount);
            p.addOptions();
        }
    }

    private void checkout(ShoppingCart cart)
    {
        double subtotal = cart.calculateSubtotal();
        double tax = cart.calculateTax();
        double total = cart.calculateTotal();

        for (Product p : productsForSale)
        {
            System.out.printf("Item:\t %s\t Price: $%.2f\t Qty: %d\t Subtotal: $%.2f%n\t\t", p.getName(), p.getPrice(), p.getQuantity(), p.calculateProductSubtotal());
            p.printOptions();
            System.out.println();
        }

        System.out.printf("Purchase Subtotal: $%.2f%n", subtotal);
        System.out.printf("Salex Tax $%.2f%n", tax);
        System.out.printf("Purchase Total: $%.2f%n", total);
    }
}
