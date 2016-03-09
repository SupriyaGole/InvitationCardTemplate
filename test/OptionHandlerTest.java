import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class OptionHandlerTest {
    @Test
    public void getOptAndFile_returns_the_hashmap_of_provided_option() throws Exception {
        OptionHandler arguments = new OptionHandler(new String[]{"--nameFormat", "lastFirst", "--country", "Bangladesh", "--file", "records"});
        HashMap<String, String> commandHashMap = arguments.getHashOfOptions();
        assertEquals(commandHashMap.get("nameFormat"),"lastFirst");
        assertEquals(commandHashMap.get("country"),"Bangladesh");
        assertEquals(commandHashMap.get("file"),"records");
    }

    @Test(expected = Exception.class)
    public void getHashOfOptions_throws_exception_when_file_name_is_unavailable() throws Exception {
        try {
            OptionHandler arguments = new OptionHandler(new String[]{"--nameFormat", "lastFirst", "--country", "Bangladesh"});
            arguments.getHashOfOptions();
        }catch (Exception e){
            assertEquals(e.getMessage(),"File is not provided. Please provide file name");
            throw e;
        }
    }

    @Test
    public void getFile_returns_filename() throws Exception {
        OptionHandler arguments = new OptionHandler(new String[]{"--nameFormat", "lastFirst", "--country", "Bangladesh", "--file", "records"});
        assertEquals(arguments.getFile(),"records");
    }
}