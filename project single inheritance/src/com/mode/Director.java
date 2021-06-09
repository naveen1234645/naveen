package com.model;

public class Director extends Manager{
    private double carAllowance;
    public Director()
    {
        super();
    }
    public Director(double carAllowance){
        this.carAllowance =carAllowance;
    }
    public double getcarAllowance(){

        return carAllowance;
    }
    public void setcarAllowance(double carAllowance){

        this.carAllowance=carAllowance;
    }
    public String getDetails(){
        return super.getDetails()+"increaseAllowance"+getcarAllowance();
    }
}
