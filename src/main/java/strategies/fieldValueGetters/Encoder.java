package strategies.fieldValueGetters;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Encoder {

    public Encoder(){}

    public String encode(String stringToEncode){
        StringBuilder builder = new StringBuilder();

        for(char c : stringToEncode.toCharArray()){
            String newValue = encodeMap.get(c);
            if(newValue != null){
                builder.append(c);
            }
        }
        return builder.toString();
    }



    private static Map<Character, String> encodeMap = new HashMap<Character, String>(){{
       put('а', "a");
       put('б', "b");
    }};

}






