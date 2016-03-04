public class InvitationCardOperations {

    private String data;
    private String guestDetails;

    public InvitationCardOperations(String data) {
        this.data = data;
    }

    public String guestDataRetrieval(String format,String choice) throws Exception {
        guestDetails = "";
        String[] records = data.split("\n");
        for (String record1 : records) {
            String[] record = record1.split(",");
            Person person = new Person(record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
            guestDetails += choice.equals("withoutCountry") ? (person.getName(format)+"\n") : (person.getNameWithCountry(format)+"\n");
        }
        return guestDetails;
    }
}
