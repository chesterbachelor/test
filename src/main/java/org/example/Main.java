package org.example;

import org.example.brewery.Brewery;
import org.example.brewery.beer.Ale;
import org.example.brewery.employee.Days;

public class Main {

    public static void main(String[] args) {
        Brewery brewery = new Brewery();
        brewery.hireMasterBrewer("Michael", 5);
        brewery.hireHelper("Bartek",2, Days.SATURDAY,Days.SATURDAY);
        brewery.hireHelper("Kamil",2, Days.MONDAY,Days.SATURDAY);
        brewery.hireHelper("Marek",2, Days.FRIDAY,Days.SATURDAY);
        brewery.hireHelper("Damian",2, Days.SUNDAY,Days.SATURDAY);
        brewery.printStock();

        brewery.brewBeer(5,Days.SATURDAY);
        brewery.orderBeers(new Ale("Tyskie",2), 20);
    }
}