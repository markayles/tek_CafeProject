package com.teksystems.Project3;

public class Coffee extends Product
{
    private boolean sugar;
    private boolean milk;

    //region Getters & Setters
    public Boolean getSugar()
    {
        return sugar;
    }

    public void setSugar(Boolean sugar)
    {
        this.sugar = sugar;
    }

    public Boolean getMilk()
    {
        return milk;
    }

    public void setMilk(Boolean milk)
    {
        this.milk = milk;
    }
    //endregion

    public Coffee()
    {
        super();
        this.sugar = false;
        this.milk = false;
    }

    public Coffee(String name, String description, double price, boolean sugar, boolean milk)
    {
        super(name, description, price);
        this.sugar = sugar;
        this.milk = milk;
    }

    @Override
    public double calculateProductSubtotal()
    {
        return this.getPrice() * this.getQuantity();
    }

    @Override
    public void addOptions()
    {
        System.out.print("Would you like to add sugar? (Y/N): ");
        String response = CafeApp3.scan.nextLine();
        if(response.equalsIgnoreCase("y"))
        {
            this.sugar = true;
        }

        System.out.print("Would you like to add milk? (Y/N): ");
        response = CafeApp3.scan.nextLine();
        if(response.equalsIgnoreCase("y"))
        {
            this.sugar = true;
        }
    }

    @Override
    public void printOptions()
    {
        System.out.printf("Sugar: %s Milk: %s", (this.sugar ? "Yes" : "No"), (this.milk ? "Yes" : "No"));
    }
}
