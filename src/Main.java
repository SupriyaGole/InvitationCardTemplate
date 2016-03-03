import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile readFile = new ReadFile();
        String data = readFile.read();
        InvitationCard card = new InvitationCard(data);
        card.extractRecord();
    }
}
