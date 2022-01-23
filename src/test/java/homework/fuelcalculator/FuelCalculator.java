package homework.fuelcalculator;

import org.junit.jupiter.api.Test;

public class FuelCalculator {

    //rashod avtomobila na 100 kilometrov
    //metod - 2 parametra, 1 rashod na 100, vtoroj kolvo kilometrov
    //skoljko litrov topliva neobhodimo


    private int requiredFuel(int consumption, int distance) {
        return (distance / 100) * consumption;
    }

    @Test
    public void test() {
        int fuelAmountOne = requiredFuel(8, 1000);
        int fuelAmountTwo = requiredFuel(50, 400);
        int fuelAmountThree = requiredFuel(80, 20000);

        System.out.println("1st ride fuel amount equals " + fuelAmountOne);
        System.out.println("2nd ride fuel amount equals " + fuelAmountTwo);
        System.out.println("3rd ride fuel amount equals " + fuelAmountThree);
    }
}
