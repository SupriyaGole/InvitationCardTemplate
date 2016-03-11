import cli.ProcessGuestChoice;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrintLableOptTest {

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format() throws Exception {
        ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "lastFirst", "--file", "records"});
        assertEquals("Mr Hills, Catharine\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format() throws Exception {
        ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "firstFirst","--file", "records"});
        assertEquals("Mr Catharine Hills\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format_with_country_name() throws Exception {
        ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "lastFirst", "--country", "Macedonia", "--file", "records"});
        assertEquals("Mr Hills, Catharine,Macedonia\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format_with_country_name() throws Exception {
        ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "firstFirst", "--country", "Macedonia", "--file", "records"});
        assertEquals("Mr Catharine Hills,Macedonia\n",guestData);
    }

    @Test
    public void guestDataRetrieval_returns_nothing_when_provided_country_name_is_unavailable_in_record() throws Exception {
        ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        assertEquals(processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "lastFirst", "--country", "Bangladesh", "--file", "records"}),"");
    }

    @Test(expected = Exception.class)
    public void guestDataRetrieval_throws_exception_when_given_nameFormat_is_invalid() throws Exception {
        try {
            ProcessGuestChoice processGuestChoice = new ProcessGuestChoice("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
            processGuestChoice.retrieveGuestData(new String[]{"--nameFormat", "lastLast", "--country", "Macedonia", "--file", "records"});
        }
        catch(Exception e){
            assertEquals(e.getMessage(),"Given format is invalid");
            throw e;
        }

    }
}
