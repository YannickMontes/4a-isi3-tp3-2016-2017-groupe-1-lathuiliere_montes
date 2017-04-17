package persons;

import org.junit.Before;
import people.YetAnotherPerson;

import java.util.GregorianCalendar;

/**
 * Created by yannick on 11/04/17.
 */
public class YetAnotherPersonTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.birthday = new GregorianCalendar(1994, 7, 15);
        this.person = new YetAnotherPerson("Yoann", "Lathuiliere",
                birthday.YEAR, birthday.MONTH, birthday.DAY_OF_MONTH);
    }
}
