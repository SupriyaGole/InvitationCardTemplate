import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format() throws Exception {
        Person person = new Person("Supriya", "Gole","Female",18, "Karad", "Maharashtra", "India");
        assertEquals(person.getName("firstFirst"),"Ms Supriya Gole");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format() throws Exception {
        Person person = new Person("Supriya", "Gole","Female",18, "Karad", "Maharashtra", "India");
        assertEquals(person.getName("lastFirst"),"Ms Gole, Supriya");
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format() throws Exception {
        Person person = new Person("Satyam", "Gole","Male",18, "Karad", "Maharashtra", "India");
        assertEquals(person.getName("firstFirst"),"Mr Satyam Gole");
    }

    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format() throws Exception {
        Person person = new Person("Satyam", "Gole","Male",18, "Karad", "Maharashtra", "India");
        assertEquals(person.getName("lastFirst"),"Mr Gole, Satyam");
    }

    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = new Person("Supriya", "Gole", "Female",18,"Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("firstFirst"),"Ms Supriya Gole,India");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = new Person("Supriya", "Gole", "Female",18,"Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("lastFirst"),"Ms Gole, Supriya,India");
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = new Person("Satyam", "Gole", "Male",18,"Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("firstFirst"),"Mr Satyam Gole,India");
    }


    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = new Person("Satyam", "Gole","Male",18, "Karad", "Maharashtra", "India");
        assertEquals(person.getNameWithCountry("lastFirst"),"Mr Gole, Satyam,India");
    }
}
