package messages.fields;

import java.util.*;

public enum FieldName {

    ID("id"),
    DATE("date"),
    SENDER("from"),
    PHOTO_PATH("photo"),
    TEXT("text"),
    OTHER("empty");


    private final String value;


    FieldName (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FieldName createFieldName(String value){

        FieldName fieldName = fieldNameGetter.get(value);

        if (fieldName == null){
           return FieldName.OTHER;
        }
        else return fieldName;
    }

    private static final Map<String, FieldName> fieldNameGetter = new HashMap<String, FieldName>(){{
        put("id", FieldName.ID);
        put("date", FieldName.DATE);
        put("from", FieldName.SENDER);
        put("photo", FieldName.PHOTO_PATH);
        put("text", FieldName.TEXT);
    }};

}
