import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format() throws Exception {
        Person person = new Person("Maria", "Roy", "Female", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getName("firstFirst"), "Ms Maria Roy");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format() throws Exception {
        Person person = new Person("Maria", "Roy", "Female", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getName("lastFirst"), "Ms Roy, Maria");
    }

    @Test(expected = Exception.class)
    public void get_throws_exception_when_given_format_is_invalid() throws Exception {
        try {
            Person person = new Person("Maria", "Roy", "Female", "18", "Karad", "Maharashtra", "India");
            person.getName("firstSecond");
        } catch (Exception err) {
            assertEquals(err.getMessage(), "Given format is invalid");
            throw err;
        }
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format() throws Exception {
        Person person = new Person("John", "Roy", "Male", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getName("firstFirst"), "Mr John Roy");
    }

    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format() throws Exception {
        Person person = new Person("John", "Roy", "Male", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getName("lastFirst"), "Mr Roy, John");
    }

    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = new Person("Maria", "Roy", "Female", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("firstFirst"), "Ms Maria Roy,India");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = new Person("Maria", "Roy", "Female", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("lastFirst"), "Ms Roy, Maria,India");
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = new Person("John", "Roy", "Male", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("firstFirst"), "Mr John Roy,India");
    }


    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = new Person("John", "Roy", "Male", "18", "Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("lastFirst"), "Mr Roy, John,India");
    }
}
