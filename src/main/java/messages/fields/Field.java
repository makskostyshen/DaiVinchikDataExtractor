package messages.fields;

import com.google.gson.stream.JsonToken;
import messages.fields.fieldValues.FieldValue;

public class Field {
    FieldName fieldName;
    JsonToken fieldType;
    FieldValue fieldValue;

    public Field(FieldName fieldName, FieldValue fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public FieldName getName(){
        return fieldName;
    }

    public Object getValue() {
        return fieldValue.getValue();
    }

    @Override
    public String toString() {
        return fieldType + ", value = " + fieldValue.getValue();
    }
}
