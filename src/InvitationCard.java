public class InvitationCard {

    private String data;

    public InvitationCard(String data) {
        this.data = data;
    }

    public void extractRecord(){
        String[] records = data.split("\n");
        for (int i=0;i<records.length;i++){
            String[] record = records[i].split(",");
        }
    }
}
