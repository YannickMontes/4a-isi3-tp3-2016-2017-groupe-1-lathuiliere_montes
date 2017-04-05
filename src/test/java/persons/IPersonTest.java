package persons;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import persons.IPerson;
import java.util.GregorianCalendar;

public abstract class IPersonTest
{
	protected IPerson person;
	protected GregorianCalendar date;

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
	@Ignore
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









    @Test(expected = NullPointerException.class)
    public void should_give_illegalArgumentException_on_null_date() throws Exception
    {
        date = null;

        person.wasBorn(date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_date_before_birthday() throws Exception
    {
        date = new GregorianCalendar(1990, 1, 1);

        person.getAge(date);
    }

    @Test
	@Ignore
    public void should_give_zero_on_date_same_as_birthday() throws Exception
    {
        date = new GregorianCalendar(1994, 7, 15);

        int result = person.getAge(date);

        assertThat(result).isEqualTo(0);
    }

    @Test
	@Ignore
    public void should_give_twelve_on_date_twelve_years_after_birth_date() throws Exception
    {
        date = new GregorianCalendar(2006, 7, 15);

        int result = person.getAge(date);

        assertThat(result).isEqualTo(12);
    }
}
