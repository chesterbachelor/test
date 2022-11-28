package org.example.brewery;

import org.example.brewery.beer.Ale;
import org.example.brewery.beer.Beer;
import org.example.brewery.beer.Lager;
import org.example.brewery.employee.Days;
import org.example.brewery.employee.Helper;
import org.example.brewery.employee.MasterBrewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brewery {
    private MasterBrewer master;
    private final List<Helper> helperList;
    private Map<Beer, Integer> stock;

    public Brewery() {
        helperList = new ArrayList<>();
        createStock();
    }

    public void hireMasterBrewer(String name, int yearsOfExperience) {
        master = new MasterBrewer(name, yearsOfExperience);
    }

    public void hireHelper(String name, int yearsOfExperience, Days... workingDays) {
        helperList.add(new Helper(name, yearsOfExperience, workingDays));
    }

    public void orderBeers(Beer beer, int amount) {
        if(!stock.containsKey(beer)){
            System.out.println("We dont have that beer");
            return;
        }
        if (stock.get(beer) > amount) {
            System.out.println("We can provide this order for you");
        } else {
            System.out.println("Sorry, we dont have that many beers");
        }
    }

    public void brewBeer(int amountToBrew, Days day) {
        int amountOfWorkersInSpecificDay = (int) helperList.stream()
                .filter(worker -> worker.getWorkingDays().contains(day))
                .count();

        if (amountOfWorkersInSpecificDay <= 0) {
            System.out.println("No helpers to brew");
        } else {
            do {
                brewOneBeer();
                amountToBrew--;
                amountOfWorkersInSpecificDay--;
            } while (amountToBrew > 0 || amountOfWorkersInSpecificDay > 0);
            System.out.println("We;ve brewed as much as we could");
        }

    }

    private void brewOneBeer() {
        Beer toBrew = stock.keySet().stream().findAny().get();
        stock.put(toBrew, stock.get(toBrew) + 1);
    }

    private void createStock() {
        stock = new HashMap<>();
        stock.put(new Ale("Guiness", 5), 100);
        stock.put(new Ale("Tyskie", 2), 100);
        stock.put(new Lager("Perla", 8), 100);
    }
    public void printStock(){
        for(Beer beer : stock.keySet()){
            System.out.println(beer.getName());
            System.out.println(stock.get(beer));
        }
    }


}
