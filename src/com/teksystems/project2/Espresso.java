package com.teksystems.project2;

public class Espresso extends Product
{
    private boolean extraShot;
    private boolean macchiato;

    //region Getters & Setters
    public boolean isExtraShot()
    {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot)
    {
        this.extraShot = extraShot;
    }

    public boolean isMacchiato()
    {
        return macchiato;
    }

    public void setMacchiato(boolean macchiato)
    {
        this.macchiato = macchiato;
    }
    //endregion

    public Espresso()
    {
        super();
        this.extraShot = false;
        this.macchiato = false;
    }

    public Espresso(String name, String description, double price, boolean extraShot, boolean macchiato)
    {
        super(name, description, price);
        this.extraShot = extraShot;
        this.macchiato = macchiato;
    }

    @Override
    public double calculateProductSubtotal()
    {
        double subtotal = 0;

        if (extraShot) {subtotal += 2.0;}
        if (macchiato) {subtotal += 1.0;}

        subtotal += this.getPrice() * this.getQuantity();

        return subtotal;
    }
}