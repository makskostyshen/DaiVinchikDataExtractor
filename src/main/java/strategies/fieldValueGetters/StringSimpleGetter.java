package strategies.fieldValueGetters;

import com.google.gson.stream.JsonReader;
import messages.fields.fieldValues.FieldValue;
import messages.fields.fieldValues.StringFieldValue;

import java.io.IOException;

public class StringSimpleGetter implements FieldValueGetter {

    private JsonReader reader;

    public StringSimpleGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public FieldValue get() throws IOException {
        return new StringFieldValue(reader.nextString());
    }
}
