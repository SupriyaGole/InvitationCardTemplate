public class InvitationCard {

    private String data;

    public InvitationCard(String data) {
        this.data = data;
    }

    public void extractRecord(){
        String[] records = data.split("\n");
        for (int i=0;i<records.length;i++){
            String[] record = records[i].split(",");
            Person person = new Person(record[0], record[1], record[2], Integer.parseInt(record[3]), record[4], record[5], record[6]);
            System.out.println("person = " + person.getName("lastFirst"));
        }
    }
}
