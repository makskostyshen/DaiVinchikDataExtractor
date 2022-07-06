package strategies.fieldValueGetters;

import com.google.gson.stream.JsonReader;
import messages.fields.fieldValues.FieldValue;
import messages.fields.fieldValues.StringFieldValue;

import java.io.IOException;

public class EmptyGetter implements FieldValueGetter{

    private JsonReader reader;

    public EmptyGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public FieldValue get() throws IOException {
        reader.skipValue();
        return new StringFieldValue("");
    }
}