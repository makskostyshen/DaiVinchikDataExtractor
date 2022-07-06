package readers;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import messages.fields.FieldType;
import messages.fields.Field;
import messages.fields.fieldValues.FieldValue;
import strategies.fieldValueGetters.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FieldReader {

    private JsonReader innerReader;

    public FieldReader(String jsonFilePath) throws FileNotFoundException {
        innerReader = new JsonReader(new BufferedReader(new FileReader(jsonFilePath)));
    }

    public void readInitialFields() throws IOException {
        innerReader.beginObject();

        String name1 = innerReader.nextName();
        String value1 = innerReader.nextString();

        System.out.println(name1 + " " + value1);

        String name2 = innerReader.nextName();
        String value2 = innerReader.nextString();

        System.out.println(name2 + " " + value2);

        String name3 = innerReader.nextName();
        int value3 = innerReader.nextInt();

        System.out.println(name3 + " " + value3);

        System.out.println(innerReader.peek());
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

        FieldType type = getFieldType();
        FieldValueGetter valueGetter = getValueGetter(type);

        FieldValue value = valueGetter.get();
        return new Field(type, value);
    }

    public void beginMessage() throws IOException {
        innerReader.beginObject();
    }

    public void endMessage() throws IOException {
        innerReader.endObject();
    }


    private FieldType getFieldType() throws IOException {
        String name = innerReader.nextName();
        JsonToken token = innerReader.peek();
        return new FieldType(name, token);
    }

    private FieldValueGetter getValueGetter(FieldType fieldType){
        String typeString = fieldType.getName();
        if ("date".equals(typeString) || "from".equals(typeString) || "photo".equals(typeString)) {
            return new StringSimpleGetter(innerReader);
        } else if ("text".equals(typeString)) {
            return new StringComplexGetter(innerReader);
        } else if ("id".equals(typeString)) {
            return new IntSimpleGetter(innerReader);
        }
        return new EmptyGetter(innerReader);
    }

}
