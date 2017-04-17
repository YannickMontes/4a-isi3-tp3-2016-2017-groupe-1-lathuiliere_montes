package persons;

import org.junit.Before;
import people.YetAnotherPerson;

/**
 * Created by yannick on 11/04/17.
 */
public class SmallCodePerson extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.person = new people.SmallCodePerson("Yoann", "Lathuiliere", 1994, 7, 15);
    }
}
