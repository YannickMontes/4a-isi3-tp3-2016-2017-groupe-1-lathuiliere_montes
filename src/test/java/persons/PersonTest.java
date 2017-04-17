package persons;

import org.junit.Before;
import people.YetAnotherPerson;

import java.util.GregorianCalendar;

/**
 * Created by yannick on 05/04/17.
 */
public class PersonTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.birthday = new GregorianCalendar(1994, 7, 15);
        this.person = new persons.Person("Yoann", "Lathuiliere",
                birthday.YEAR, birthday.MONTH, birthday.DAY_OF_MONTH);
    }
}
