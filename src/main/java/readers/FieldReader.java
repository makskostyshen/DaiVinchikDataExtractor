package readers;

import com.google.gson.stream.JsonReader;
import messages.fields.FieldName;
import messages.fields.Field;
import messages.fields.fieldValues.FieldValue;
import strategies.fieldValueGetters.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FieldReader {

    private final JsonReader innerReader;

    public FieldReader(String jsonFilePath) throws FileNotFoundException {
        innerReader = new JsonReader(new BufferedReader(new FileReader(jsonFilePath)));
    }

    public void readInitialFields() throws IOException {
        innerReader.beginObject();

        String name1 = innerReader.nextName();
        String value1 = innerReader.nextString();

        String name2 = innerReader.nextName();
        String value2 = innerReader.nextString();

        String name3 = innerReader.nextName();
        int value3 = innerReader.nextInt();

        innerReader.nextName();
        innerReader.beginArray();
    }

    public void readFinalFields() throws IOException {
        innerReader.endArray();
        innerReader.endObject();
        innerReader.close();
    }

    public boolean hasNextField() throws IOException {
        return innerReader.hasNext();
    }

    public Field getNextField() throws IOException {

        FieldName fieldName = FieldName.createFieldName(innerReader.nextName());

        FieldValueGetter valueGetter = getValueGetter(fieldName);
        FieldValue value = valueGetter.get();

        return new Field(fieldName, value);
    }

    public void beginMessage() throws IOException {
        innerReader.beginObject();
    }

    public void endMessage() throws IOException {
        innerReader.endObject();
    }


    private FieldValueGetter getValueGetter(FieldName fieldName){

        switch (fieldName){
            case DATE:
            case PHOTO_PATH:
            case SENDER:
                return new StringSimpleGetter(innerReader);
            case TEXT:
                return new StringComplexGetter(innerReader);
            case ID:
                return new IntSimpleGetter(innerReader);
            default:
                return new EmptyGetter(innerReader);
        }
    }

}
