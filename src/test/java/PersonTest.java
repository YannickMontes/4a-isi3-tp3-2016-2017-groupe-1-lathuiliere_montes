import persons.Person;

/**
 * Created by yannick on 05/04/17.
 */
public class PersonTest extends IPersonTest
{
    @Override
    public void setUp() throws Exception
    {
        this.person = new Person("Yoann", "Lathuiliere", 1995, 7, 15);
    }
}
