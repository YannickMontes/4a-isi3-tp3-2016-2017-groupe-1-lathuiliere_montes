package persons;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import java.util.GregorianCalendar;

public abstract class IPersonTest
{
	protected IPerson person;
	protected GregorianCalendar birthday;

	@Test(expected = NullPointerException.class)
	public void should_give_nullPointerException_on_null_date() throws Exception
	{
        GregorianCalendar date = null;

		person.wasBorn(date);
	}

    @Test
    public void should_give_false_on_day_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH) -1);

        boolean result = person.wasBorn(date);

        assertThat(result).isFalse();
    }

    @Test
    public void should_give_false_on_month_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH)-1, birthday.get(birthday.DAY_OF_MONTH));

        boolean result = person.wasBorn(date);

        assertThat(result).isFalse();
    }

    @Test
    public void should_give_false_on_year_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR)-1, birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH) );
        
        boolean result = person.wasBorn(date);

        assertThat(result).isFalse();
    }

	@Test
	public void should_give_true_on_date_equals_to_birthday() throws Exception
	{
		boolean result = person.wasBorn(birthday);

		assertThat(result).isTrue();
	}

	@Test
	public void should_give_true_on_year_after_birthday() throws Exception
	{
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR) + 1, birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH));

		boolean result = person.wasBorn(date);

		assertThat(result).isTrue();
	}

	@Test
    public void should_give_true_on_month_after_birthday()
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH) +1, birthday.get(birthday.DAY_OF_MONTH));

        boolean result = person.wasBorn(date);

        assertThat(result).isTrue();
    }

    @Test
    public void should_give_true_on_day_after_birthday()
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH)+1);

        boolean result = person.wasBorn(date);

        assertThat(result).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void should_give_illegalArgumentException_on_null_date() throws Exception
    {
        GregorianCalendar date = null;

        person.wasBorn(date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_day_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH) - 1);

        person.getAge(date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_month_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR), birthday.get(birthday.MONTH)-1, birthday.get(birthday.DAY_OF_MONTH));

        person.getAge(date);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_give_illegalArgumentException_on_year_before_birthday() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR) - 1, birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH));

        date.add(GregorianCalendar.YEAR, -1);

        person.getAge(date);
    }

    @Test
	public void should_give_zero_on_date_same_as_birthday() throws Exception
    {
        int result = person.getAge(birthday);

        assertThat(result).isEqualTo(0);
    }

    @Test
	public void should_give_twelve_on_date_twelve_years_after_birth_date() throws Exception
    {
        GregorianCalendar date = new GregorianCalendar(birthday.get(birthday.YEAR) + 12, birthday.get(birthday.MONTH), birthday.get(birthday.DAY_OF_MONTH));

        int result = person.getAge(date);

        assertThat(result).isEqualTo(12);
    }
}
