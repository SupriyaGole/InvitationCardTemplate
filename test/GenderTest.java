import guest.Gender;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenderTest {
    @Test
    public void test_isMale_returns_true_when_guest_is_male() throws Exception {
        Gender gender = new Gender("Male");
        assertTrue(gender.isMale());
    }

    @Test
    public void test_isMale_returns_false_when_guest_is_male() throws Exception {
        Gender gender = new Gender("Female");
        assertFalse(gender.isMale());
    }
}