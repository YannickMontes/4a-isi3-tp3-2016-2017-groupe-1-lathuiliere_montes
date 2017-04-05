import org.junit.Before;
import persons.Person;

/**
 * Created by yannick on 05/04/17.
 */
public class PersonTest extends IPersonTest
{
    @Before
    public void setUp() throws Exception
    {
        this.person = new Person("Yoann", "Lathuiliere", 1995, 7, 15);
    }
}
