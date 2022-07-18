package messages.fields.fieldValues;


import mainClasses.Encoder;

import java.io.UnsupportedEncodingException;

public class StringFieldValue implements FieldValue {

    private String value;

    public StringFieldValue(String value) throws UnsupportedEncodingException {
        Encoder encoder = new Encoder();
        this.value = encoder.encode(value);

        //System.out.println("new_encoded_value_is: " + this.value+ "\n");
    }

    @Override
    public String getValue() {
        return value;
    }
}
