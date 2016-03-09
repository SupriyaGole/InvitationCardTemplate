import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private PersonBehaviourCreator female;
    private PersonBehaviourCreator male;

    public HashMap<String, String> createHashOfChoice(String[] choices){
        String[] keys={"nameFormat","country","ageLimit"};
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int index = 0; index < choices.length; index++) {
            hashMap.put(keys[index],choices[index]);
        }
        hashMap.put("file","records");
        return hashMap;
    }

    @Before
    public void setUp() throws Exception {
        String dataAboutFemale = "Maria,Roy,Female,18,Karad,Maharashtra,India";
        female = new PersonBehaviourCreator(dataAboutFemale);
        String dataAboutMale = "John,Roy,Male,18,Karad,Maharashtra,India";
        male = new PersonBehaviourCreator(dataAboutMale);
    }

    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format() throws Exception {
        Person person = female.getPersonObject();
        assertEquals(person.getRepresentation("firstFirst"), "Ms Maria Roy");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format() throws Exception {
        Person person = female.getPersonObject();
        assertEquals(person.getRepresentation("lastFirst"), "Ms Roy, Maria");
    }

    @Test(expected = Exception.class)
    public void get_throws_exception_when_given_format_is_invalid() throws Exception {
        try {
            Person person = female.getPersonObject();
            person.getRepresentation("firstSecond");
        } catch (Exception err) {
            assertEquals(err.getMessage(), "Given format is invalid");
            throw err;
        }
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format() throws Exception {
        Person person = male.getPersonObject();
        assertEquals(person.getRepresentation("firstFirst"), "Mr John Roy");
    }

    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format() throws Exception {
        Person person = male.getPersonObject();
        assertEquals(person.getRepresentation("lastFirst"), "Mr Roy, John");
    }

    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = female.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"firstFirst", "India"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country")), "Ms Maria Roy,India");
    }

    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = female.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"lastFirst", "India"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country")), "Ms Roy, Maria,India");
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format_with_country_name() throws Exception {
        Person person = male.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"firstFirst", "India"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country")), "Mr John Roy,India");
    }

    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format_with_country_name() throws Exception {
        Person person = male.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"lastFirst", "India"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country")), "Mr Roy, John,India");
    }

    @Test
    public void get_returns_name_of_female_guest_in_firstLast_format_with_country_name_above_specific_age() throws Exception {
        Person person = female.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"firstFirst", "India","15"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country"),Integer.parseInt(hashOfChoice.get("ageLimit"))), "Ms Maria Roy,India, 18");
    }
//
    @Test
    public void get_returns_name_of_female_guest_in_lastFirst_format_with_country_name_above_specific_age() throws Exception {
        Person person = female.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"lastFirst", "India","15"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country"),Integer.parseInt(hashOfChoice.get("ageLimit"))), "Ms Roy, Maria,India, 18");
    }

    @Test
    public void get_returns_name_of_male_guest_in_firstLast_format_with_country_name_above_specific_age() throws Exception {
        Person person = male.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"firstFirst", "India","15"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country"),Integer.parseInt(hashOfChoice.get("ageLimit"))), "Mr John Roy,India, 18");
    }

    @Test
    public void get_returns_name_of_male_guest_in_lastFirst_format_with_country_name_above_specific_age() throws Exception {
        Person person = male.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"lastFirst", "India","15"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country"),Integer.parseInt(hashOfChoice.get("ageLimit"))), "Mr Roy, John,India, 18");
    }

    @Test
    public void test_getRepresentation_gives_empty_string_when_given_persons_age_is_below_threshold() throws Exception {
        Person person = male.getPersonObject();
        HashMap<String, String> hashOfChoice = createHashOfChoice(new String[]{"lastFirst", "India","20"});
        assertEquals(person.getRepresentation(hashOfChoice.get("nameFormat"),hashOfChoice.get("country"),Integer.parseInt(hashOfChoice.get("ageLimit"))), "");
    }
}
