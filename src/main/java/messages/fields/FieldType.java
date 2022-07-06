package messages.fields;

import com.google.gson.stream.JsonToken;

public class FieldType {

    private String name;
    private JsonToken token;

    public FieldType(String name, JsonToken token) {
        this.name = name;
        this.token = token;
    }

    public FieldType() {}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name = " + name + ", " +
                "token = " + token;
    }
}
