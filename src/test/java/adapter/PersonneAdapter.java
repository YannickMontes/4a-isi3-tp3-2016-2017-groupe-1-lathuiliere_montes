package adapter;

import persons.IPerson;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PersonneAdapter extends people.Personne implements IPerson {

    public PersonneAdapter(String lastname, String firstname, int year, int month, int day) {
        super(lastname, firstname, year, month, day); // Call to people.Personne constructor
    }

    public boolean wasBorn(GregorianCalendar date) {
        return date.before(super.dateNaissance) || date.equals(super.dateNaissance);
    }
}
