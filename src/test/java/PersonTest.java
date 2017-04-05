import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persons.Person;

import java.util.GregorianCalendar;

public class PersonTest
{
	private Person person;
	private GregorianCalendar date;

	@Before
	public void setUp() throws Exception
	{
		person = new Person("Yoann", "Lathuiliere", 1994, 7, 15);
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test(expected = NullPointerException.class)
	public void should_give_nullPointerException_on_null_date() throws Exception
	{
		date = null;

		person.wasBorn(date);
	}

	@Test
	public void should_give_false_on_date_before_birthday() throws Exception
	{
		date = new GregorianCalendar(1990, 1, 1);

		boolean result = person.wasBorn(date);

		assertThat(result).isFalse();
	}

	@Test
	public void should_give_true_on_date_equals_to_birthday() throws Exception
	{
		date = new GregorianCalendar(1994, 7, 15);

		boolean result = person.wasBorn(date);

		assertThat(result).isTrue();
	}

	@Test
	public void should_give_true_on_date_after_birthday() throws Exception
	{
		date = new GregorianCalendar(2000, 1, 1);

		boolean result = person.wasBorn(date);

		assertThat(result).isTrue();
	}
}
