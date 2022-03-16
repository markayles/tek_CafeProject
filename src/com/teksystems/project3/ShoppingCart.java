package com.teksystems.project3;

import java.util.ArrayList;

public class ShoppingCart
{
    public static final double TAX_RATE = 0.06f;
    private ArrayList<Product> shoppingCartReference;

    public ShoppingCart(ArrayList<Product> shoppingCartReference)
    {
        this.shoppingCartReference = shoppingCartReference;
    }

    public double calculateTax()
    {
        double subtotal = calculateSubtotal();

        return subtotal * TAX_RATE;
    }

    public double calculateSubtotal()
    {
        double subtotal = 0;

        for (int i = 0; i < shoppingCartReference.size(); i++)
        {
            subtotal += shoppingCartReference.get(i).calculateProductSubtotal();
        }

        return subtotal;
    }

    public double calculateTotal()
    {
        return calculateTax() + calculateSubtotal();
    }
}
