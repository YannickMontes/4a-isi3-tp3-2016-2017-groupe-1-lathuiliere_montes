package utils;

import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.stream.Collectors.toList;


/**
 * Created by yannick on 05/04/17.
 */
public class UtilsPerson {
    public List<IPerson> getPersonsInInterval(ArrayList<IPerson> persons, int min, int max, final GregorianCalendar date) throws IllegalArgumentException{
        if(min > max) {
            throw new IllegalArgumentException("Minimal age superior at maximal age");
        }

        return persons.stream()
                .filter(person -> {
                    int age = person.getAge(date);
                    return age >= min && age <= max;
                })
                .collect(toList());
    }

    public int getAgeOfOldestPersonInList(ArrayList<IPerson> persons, final GregorianCalendar date)
    {
        if(persons.size() == 0)
        {
            return -1;
        }

        int maxAge = Integer.MIN_VALUE;

        //TO OPTIM WITH STREAM

        for(IPerson person : persons)
        {
            if(person.getAge(date) > maxAge)
                maxAge = person.getAge(date);
        }

        return maxAge;
    }
}
