import java.util.HashMap;

public class PrintLabel {
    public static void main(String[] args) throws Exception {
        SeparateArguments arguments = new SeparateArguments(args);
        HashMap<String, String> hashMap = arguments.getOptAndFile();
        ReadFile readFile = new ReadFile(hashMap.get("file"));
        String data = readFile.read();
        PrintLabelOperations card = new PrintLabelOperations(data);
        String guestInfo = card.guestDataRetrieval(hashMap);
        System.out.println(guestInfo);
    }
}
