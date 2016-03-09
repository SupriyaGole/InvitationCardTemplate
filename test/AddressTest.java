import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressTest {
    @Test
    public void test_isFrm_checks_weather_person_from_specific_country() throws Exception {
        Country country = new Country("India");
        Address address = new Address("Mumbai", "Maharashtra",country);
        assertTrue(address.isFrom("India"));
        assertFalse(address.isFrom("USA"));
    }

    @Test
    public void getCountry_name_returns_the_country_name() throws Exception {
        Country country = new Country("India");
        Address address = new Address("Mumbai", "Maharashtra",country);
        assertEquals("India",address.getCountryName());
    }
}