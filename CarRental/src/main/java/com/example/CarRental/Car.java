package com.example.CarRental;

import java.io.Serializable;

public class Car implements Serializable {

    private String plateNumber;
    private int nbSeat;
    private int price;
    private boolean rent;

    public Car() {
    }

    public Car(String plateNumber, int nbSeat, int price) {
        super();
        this.plateNumber = plateNumber;
        this.nbSeat = nbSeat;
        this.price = price;
        this.setRent(false);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getnbSeat() {
        return nbSeat;
    }

    public void setnbSeat(int nbSeat) {
        this.nbSeat = nbSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   

    public boolean getRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}
	
	 boolean rentCar() {
	        if (rent) {
	            return false;
	        }

	        rent = true;
	        return rent;
	    }

	    boolean getBackCar() {
	        if (!rent) {
	            return false;
	        }

	        rent = false;
	        return !rent;
	    }

	@Override
    public String toString() {
        return "Car [plateNumber=" + plateNumber + ", nbSeat=" + nbSeat + ", price=" + price + "]";
    }
}