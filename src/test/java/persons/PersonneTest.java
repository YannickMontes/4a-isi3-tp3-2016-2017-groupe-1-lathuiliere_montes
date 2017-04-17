package persons;

import org.junit.Before;

/**
 * Created by yannick on 11/04/17.
 */
public class PersonneTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.person = new adapter.PersonneAdapter("Yoann", "Lathuiliere", 15, 7, 1994);
    }
}
