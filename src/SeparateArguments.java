import java.util.HashMap;

public class SeparateArguments {

    private String[] args;

    public SeparateArguments(String[] args) {
        this.args = args;
    }

    public HashMap<String, String> getOptAndFile() throws Exception{
        HashMap<String, String> map = new HashMap<String, String>();
        for (int index = 0; index < args.length; index++) {
            if (args[index].startsWith("--"))
                map.put(args[index].substring(2), args[index + 1]);
        }
        if(!(map.containsKey("file")))
            throw new Exception("File is not provided. Please provide file name");
        return map;
    }
}
