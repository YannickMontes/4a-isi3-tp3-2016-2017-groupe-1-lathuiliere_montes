package utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import persons.IPerson;
import persons.Person;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by yannick on 05/04/17.
 */
public class UtilsPersonTest
{
    private ArrayList<IPerson> persons;
    private UtilsPerson utils;

    @Before
    public void setup()
    {
        utils = new UtilsPerson();
        persons = new ArrayList<IPerson>();
        IPerson person1 = Mockito.mock(Person.class);
        Mockito.when(person1.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(37);
        IPerson person2 = Mockito.mock(Person.class);
        Mockito.when(person2.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(1);
        IPerson person3 = Mockito.mock(Person.class);
        Mockito.when(person3.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(100);
        IPerson person4 = Mockito.mock(Person.class);
        Mockito.when(person4.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(25);
        IPerson person5 = Mockito.mock(Person.class);
        Mockito.when(person5.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(28);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_max_age_above_min_age()
    {
        int min_age = 30;
        int max_age = 20;

        utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());
    }

    @Test
    public void should_return_person_between_20_and_30()
    {
        int min_age = 20;
        int max_age = 30;

        List<IPerson> returnedList = utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());

        boolean result = returnedList.contains(persons.get(3))
                && returnedList.contains(persons.get(4));

        assertThat(result).isTrue();
    }
}
