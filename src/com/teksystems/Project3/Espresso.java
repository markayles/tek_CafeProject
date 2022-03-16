package com.teksystems.Project3;

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

    @Override
    public void addOptions()
    {
        System.out.print("Would you like to add an extra shot? (Y/N): ");
        String response = CafeApp3.scan.nextLine();
        if(response.equalsIgnoreCase("y"))
        {
            this.extraShot = true;
        }

        System.out.print("Would you like to add macchiato? (Y/N): ");
        response = CafeApp3.scan.nextLine();
        if(response.equalsIgnoreCase("y"))
        {
            this.macchiato = true;
        }
    }

    @Override
    public void printOptions()
    {
        System.out.printf("Extra shot: %s Macchiato: %s", (this.extraShot ? "Yes" : "No"), (this.macchiato ? "Yes" : "No"));
    }
}