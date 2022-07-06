package strategies.fieldValueGetters;

import com.google.gson.stream.JsonReader;
import messages.fields.fieldValues.FieldValue;
import messages.fields.fieldValues.IntFieldValue;

import java.io.IOException;

public class IntSimpleGetter implements FieldValueGetter{

    private JsonReader reader;

    public IntSimpleGetter(JsonReader reader) {
        this.reader = reader;
    }

    @Override
    public FieldValue get() throws IOException {
        return new IntFieldValue(reader.nextInt());
    }
}
