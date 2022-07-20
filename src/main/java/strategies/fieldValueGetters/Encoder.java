package strategies.fieldValueGetters;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Encoder {

    public Encoder(){}

    public String encode(String stringToEncode) throws UnsupportedEncodingException {
        byte[] stringBytes = stringToEncode.getBytes("CP1251");

        return new String(stringBytes, Charset.forName("CP1251"));
    }

}
