package org.example.brewery.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper extends Employee{
    private final List<Days> workingDays;
    public Helper(String name, int yearsOfExperience,Days ... days){
        super(name,yearsOfExperience);
        workingDays = new ArrayList<>();
        workingDays.addAll(Arrays.asList(days));
    }
    public List<Days> getWorkingDays(){
        return workingDays;
    }
}
