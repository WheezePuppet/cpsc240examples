/*
 * Sept 6 in-class example: a basic Car class, with constructor and methods
 * and a main().
 */
package edu.umw.stephen;

class Car {

    String make;
    String model;
    int yearsOld;
    int odo;
    double galsRemaining;
    double sizeOfTank;
    double gasMileage;

    Car(String make, String model) {
        this.make = make;
        this.model = model;
        yearsOld = 0;
        odo = 0;
        galsRemaining = 0;
        if (make.equals("Chevy") || make.equals("GM")) {
            sizeOfTank = 21;
        } else {
            sizeOfTank = 13;
        }
        if (make.equals("Chevy") && model.equals("Malibu")) {
            gasMileage = 3;
        } else {
            gasMileage = 24;
        }
    }

    void fillUp() {
        this.galsRemaining = this.sizeOfTank;
    }

    double getTankPerc() {
        double perc = galsRemaining / sizeOfTank * 100;
        return perc;
    }

    void drive(int numMiles) throws Exception {
        double galsBurned = numMiles / gasMileage;
        if (galsBurned > galsRemaining) {
            throw new Exception("Not enough gas!");
        }
        galsRemaining = galsRemaining - galsBurned;
        odo += numMiles;
    }

    public String toString() {
        return "a " + yearsOld + "-year-old " + make + " " + model;
    }

    public static void main(String args[]) {

        // Demonstrate the automatic use of ".toString()".
        Car malibu = new Car("Chevy","Malibu");
        System.out.println("my car is: " + malibu);

        Car minivan = new Car("Toyota","Sienna");
        minivan.fillUp();
        try {
            minivan.drive(10);
            minivan.drive(500);
        } catch (Exception e) {
            System.out.println("Yikes! That drive wasn't possible because:");
            System.out.println(e);
        }
        System.out.println("Your tank is " + 
            minivan.getTankPerc() + "% full.");
    }
    
}















