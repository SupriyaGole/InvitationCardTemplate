import guest.Name;
import org.junit.Assert;
import org.junit.Test;

public class NameTest {
    @Test
    public void firstNameFirst_returns_first_name_first() throws Exception {
        Name name = new Name("Maria", "Roy");
        Assert.assertEquals("Maria Roy",name.firstNameFirst());
    }

    @Test
    public void lastNameFirst_returns_last_name_first() throws Exception {
        Name name = new Name("Maria", "Roy");
        Assert.assertEquals("Roy, Maria",name.lastNameFirst());
    }
}