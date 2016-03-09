import java.util.HashMap;

public class OptionHandler {

    private String[] args;

    public OptionHandler(String[] args) {
        this.args = args;
    }

    public HashMap<String, String> getHashOfOptions() throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();
        for (int index = 0; index < args.length; index++) {
            if (args[index].startsWith("--")){
                map.put(args[index].substring(2), args[index + 1]);
                index++;
            }
        }
        if(!(map.containsKey("file")))
            throw new Exception("File is not provided. Please provide file name");
        return map;
    }

    public String getFile() throws Exception {
        return getHashOfOptions().get("file");
    }

    public String handleOptionsAndReturnData(String record) throws Exception {
        String data = "";
        PersonBehaviourCreator behaviourCreator = new PersonBehaviourCreator(record);
        Person person = behaviourCreator.getPersonObject();
        if (getHashOfOptions().size() == 2)
            data += person.getRepresentation(getHashOfOptions().get("nameFormat"));
        if (getHashOfOptions().size() == 3)
            data += person.getRepresentation(getHashOfOptions().get("nameFormat"), getHashOfOptions().get("country"));
        if (getHashOfOptions().size() == 4)
            data += person.getRepresentation(getHashOfOptions().get("nameFormat"), getHashOfOptions().get("country"),Integer.parseInt(getHashOfOptions().get("ageLimit")));
        return data;
    }
}
