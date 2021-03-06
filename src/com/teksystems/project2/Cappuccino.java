package com.teksystems.project2;

public class Cappuccino extends Product
{
    private boolean peppermint;
    private boolean whippedCream;

    //region Getters & Setters
    public boolean isPeppermint()
    {
        return peppermint;
    }

    public void setPeppermint(boolean peppermint)
    {
        this.peppermint = peppermint;
    }

    public boolean isWhippedCream()
    {
        return whippedCream;
    }

    public void setWhippedCream(boolean whippedCream)
    {
        this.whippedCream = whippedCream;
    }
    //endregion

    public Cappuccino()
    {
        this.peppermint = false;
        this.whippedCream = false;
    }

    public Cappuccino(String name, String description, double price, boolean peppermint, boolean whippedCream)
    {
        super(name, description, price);
        this.peppermint = peppermint;
        this.whippedCream = whippedCream;
    }

    @Override
    public double calculateProductSubtotal()
    {
        double subtotal = 0;

        if (peppermint) {subtotal += 2.0;}
        if (whippedCream) {subtotal += 1.0;}

        subtotal += this.getPrice() * this.getQuantity();

        return subtotal;
    }
}
