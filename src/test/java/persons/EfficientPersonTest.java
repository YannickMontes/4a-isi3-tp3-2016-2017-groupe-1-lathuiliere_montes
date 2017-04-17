package persons;

import org.junit.Before;
import people.YetAnotherPerson;

import java.util.GregorianCalendar;

/**
 * Created by yannick on 11/04/17.
 */
public class EfficientPersonTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.birthday = new GregorianCalendar(1994, 7, 15);
        int age = 22;
        this.person = new people.EfficientPerson("Yoann", "Lathuiliere", age);
    }
}
