package messages.fields;

import messages.fields.fieldValues.FieldValue;

public class Field {
    FieldType fieldType;
    FieldValue fieldValue;

    public Field(FieldType fieldType, FieldValue fieldValue) {
        this.fieldType = fieldType;
        this.fieldValue = fieldValue;
    }

    public String getName(){
        return fieldType.getName();
    }

    public Object getValue() {
        return fieldValue.getValue();
    }

    @Override
    public String toString() {
        return fieldType + ", value = " + fieldValue.getValue();
    }
}
