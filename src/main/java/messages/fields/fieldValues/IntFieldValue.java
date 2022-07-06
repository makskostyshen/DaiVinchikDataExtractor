package messages.fields.fieldValues;

public class IntFieldValue implements FieldValue {
    private int value;

    public IntFieldValue(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
