public class PrintLabel {
    public static void main(String[] args) throws Exception {
        OptionHandler optionHandler = new OptionHandler(args);
        ReadFile readFile = new ReadFile(optionHandler.getFile());
        String data = readFile.read();
        ProcessGuestChoice card = new ProcessGuestChoice(data);
        String guestInfo = card.retrieveGuestData(args);
        System.out.println(guestInfo);
    }
}
