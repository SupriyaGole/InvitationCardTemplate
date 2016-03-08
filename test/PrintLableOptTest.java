import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class PrintLableOptTest {

    public HashMap<String, String> createHashOfChoice(String[] choices){
        String[] keys={"nameFormat","country","ageLimit"};
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (int index = 0; index < choices.length; index++) {
            hashMap.put(keys[index],choices[index]);
        }
        hashMap.put("file","records");
        return hashMap;
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format() throws Exception {
        PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"lastFirst"}));
        assertEquals("Mr Hills, Catharine\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format() throws Exception {
        PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"firstFirst"}));
        assertEquals("Mr Catharine Hills\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format_with_country_name() throws Exception {
        PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"lastFirst","Macedonia"}));
        assertEquals("Mr Hills, Catharine,Macedonia\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format_with_country_name() throws Exception {
        PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"firstFirst","Macedonia"}));
        assertEquals("Mr Catharine Hills,Macedonia\n",guestData);
    }

    @Test
    public void guestDataRetrieval_returns_nothing_when_provided_country_name_is_unavailable_in_record() throws Exception {
        PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        assertEquals(printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"firstFirst","Bangladesh"})),"");
    }

    @Test(expected = Exception.class)
    public void guestDataRetrieval_throws_exception_when_given_nameFormat_is_invalid() throws Exception {
        try {
            PrintLabelOperations printLabelOperations = new PrintLabelOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
            printLabelOperations.guestDataRetrieval(createHashOfChoice(new String[]{"firstEnd","Macedonia"}));
        }
        catch(Exception e){
            assertEquals(e.getMessage(),"Given format is invalid");
            throw e;
        }

    }
}
