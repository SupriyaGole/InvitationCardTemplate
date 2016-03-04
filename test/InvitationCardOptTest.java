import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvitationCardOptTest {
    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format() throws Exception {
        InvitationCardOperations invitationCardOperations = new InvitationCardOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = invitationCardOperations.guestDataRetrieval("lastFirst","withoutCountry");
        assertEquals("Mr Hills, Catharine\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format() throws Exception {
        InvitationCardOperations invitationCardOperations = new InvitationCardOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = invitationCardOperations.guestDataRetrieval("firstFirst","withoutCountry");
        assertEquals("Mr Catharine Hills\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_lastFirst_format_with_country_name() throws Exception {
        InvitationCardOperations invitationCardOperations = new InvitationCardOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = invitationCardOperations.guestDataRetrieval("lastFirst","withCountry");
        assertEquals("Mr Hills, Catharine,Macedonia\n",guestData);
    }

    @Test
    public void guestDataRetrieval_retrieves_guest_data_according_to_firstFirst_format_with_country_name() throws Exception {
        InvitationCardOperations invitationCardOperations = new InvitationCardOperations("Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia");
        String guestData = invitationCardOperations.guestDataRetrieval("firstFirst","withCountry");
        assertEquals("Mr Catharine Hills,Macedonia\n",guestData);
    }
}
