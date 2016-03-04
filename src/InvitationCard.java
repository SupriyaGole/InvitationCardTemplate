public class InvitationCard {
    public static void main(String[] args) throws Exception {
        ReadFile readFile = new ReadFile();
        String data = readFile.read();
        InvitationCardOperations card = new InvitationCardOperations(data);
        String guestInfo = card.guestDataRetrieval("lastFirst","withCountry");
        System.out.println(guestInfo);
    }
}
