package adapter;

import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PersonneAdapter extends people.Personne implements IPerson {

    public PersonneAdapter(String lastname, String firstname, int day, int month, int year) {
        super(lastname, firstname, day, month, year); // Call to people.Personne constructor
    }

    public boolean wasBorn(GregorianCalendar date) {

        return date.after(super.dateNaissance) || date.equals(super.dateNaissance);
    }
}
