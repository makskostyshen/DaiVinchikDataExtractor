package strategies.fieldValueGetters;

import messages.fields.fieldValues.FieldValue;

import java.io.IOException;

public interface FieldValueGetter {
    FieldValue get() throws IOException;
}
