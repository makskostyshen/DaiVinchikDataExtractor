package messages.fields.fieldValues;


public class StringFieldValue implements FieldValue {

    private String value;

    public StringFieldValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
