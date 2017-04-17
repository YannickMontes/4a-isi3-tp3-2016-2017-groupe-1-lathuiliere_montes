package persons;

import org.junit.Before;

/**
 * Created by yannick on 05/04/17.
 */
public class PersonTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.person = new persons.Person("Yoann", "Lathuiliere", 1994, 7, 15);
    }
}
