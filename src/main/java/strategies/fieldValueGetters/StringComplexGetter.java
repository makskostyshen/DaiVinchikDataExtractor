package strategies.fieldValueGetters;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import messages.fields.fieldValues.FieldValue;
import messages.fields.fieldValues.StringFieldValue;

import java.io.IOException;


public class StringComplexGetter implements FieldValueGetter {

    private final JsonReader reader;

    public StringComplexGetter(JsonReader reader) {
        this.reader = reader;
    }


    @Override
    public FieldValue get() throws IOException {
        if(reader.peek() == JsonToken.STRING){
            return new StringFieldValue(reader.nextString());
        }
        else{
            return getStringFromArray();
        }
    }

    private FieldValue getStringFromArray() throws IOException {
        reader.beginArray();
        StringBuilder builder = new StringBuilder();

        while(reader.hasNext()){
            if(reader.peek() == JsonToken.STRING){
                String nextString = reader.nextString();
                builder.append(nextString);
            }
            else{
                builder.append(getStringFromObject());
            }
        }

        reader.endArray();
        return new StringFieldValue(builder.toString());
    }

    private String getStringFromObject() throws IOException {
        reader.beginObject();
        String significantValue = "";

        while(reader.hasNext()){
            String name = reader.nextName();
            String currentValue = reader.nextString();
            
            if (name.equals("text")){
                significantValue = currentValue;
            }
        }
        reader.endObject();
        return significantValue;
    }


}
