package utils;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyObject;
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
    private IPerson personUnder30;
    private IPerson personAbove30;
    private IPerson person30;
    private IPerson person18;
    private IPerson personMaxAge;
    private UtilsPerson utils;
    private int maxAge;
    private int errorCode;

    @Before
    public void setup()
    {
        utils = new UtilsPerson();
        persons = new ArrayList();
        maxAge = 100;
        errorCode = -1;

        personUnder30 = Mockito.mock(Person.class);
        Mockito.when(personUnder30.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(28);

        personAbove30 = Mockito.mock(Person.class);
        Mockito.when(personAbove30.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(35);

        person30 = Mockito.mock(Person.class);
        Mockito.when(person30.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(30);

        person18 = Mockito.mock(Person.class);
        Mockito.when(person18.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(18);

        personMaxAge = Mockito.mock(Person.class);
        Mockito.when(personMaxAge.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(maxAge);

        persons.add(personUnder30);
        persons.add(personAbove30);
        persons.add(person30);
        persons.add(person18);
        persons.add(personMaxAge);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_max_age_above_min_age()
    {
        int min_age = 30;
        int max_age = 20;

        utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());
    }

    @Test
    public void should_give_person_between_20_and_30()
    {
        int min_age = 20;
        int max_age = 30;

        List<IPerson> returnedList = utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());

        assertThat(returnedList).containsExactlyInAnyOrder(person30, personUnder30);

        checkFunctionsUsed();
    }

    @Test
    public void should_give_false_for_persons_not_between_20_and_30()
    {
        int min_age = 20;
        int max_age = 30;

        List<IPerson> returnedList = utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());

        assertThat(returnedList).doesNotContain(personMaxAge, personAbove30, person18);

        checkFunctionsUsed();
    }

    @Test
    public void should_give_person30()
    {
        int min_age = 30;
        int max_age = 30;

        List<IPerson> returnedList = utils.getPersonsInInterval(persons, min_age, max_age, new GregorianCalendar());

        assertThat(returnedList).containsExactly(person30);

        checkFunctionsUsed();
    }

    @Test
    public void should_give_error_code_with_empty_list()
    {
        int result = utils.getAgeOfOldestPersonInList(new ArrayList<IPerson>(), new GregorianCalendar());

        assertThat(result).isEqualTo(errorCode);
    }

    @Test
    public void should_give_error_code_with_null_list()
    {
        int result = utils.getAgeOfOldestPersonInList(null, new GregorianCalendar());

        assertThat(result).isEqualTo(errorCode);
    }

    @Test
    public void should_give_oldest_person_with_list()
    {
        int result = utils.getAgeOfOldestPersonInList(persons, new GregorianCalendar());

        assertThat(result).isEqualTo(maxAge);

        checkFunctionsUsed();
    }

    private void checkFunctionsUsed()
    {
        for(IPerson person : persons)
        {
            verify(person, atLeastOnce()).getAge(anyObject());
            verify(person, never()).getFirstName();
            verify(person, never()).getName();
        }
    }
}
