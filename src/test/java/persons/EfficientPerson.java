package persons;

import org.junit.Before;
import people.YetAnotherPerson;

/**
 * Created by yannick on 11/04/17.
 */
public class EfficientPerson extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.person = new people.EfficientPerson("Yoann", "Lathuiliere", 22);
    }
}
