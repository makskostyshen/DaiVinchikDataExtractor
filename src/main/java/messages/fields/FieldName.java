package messages.fields;

import java.util.Locale;

public enum FieldName {

    ID("id"),
    TYPE("type"),
    DATE("date"),
    DATE_UNIXTIME("date_unixtime"),
    FROM("from"),
    FROM_ID("from_id"),
    PHOTO("photo"),
    WIDTH("width"),
    HEIGHT("height"),
    TEXT("text");


    private final String value;

    FieldName (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FieldName createFieldName(String value){
        return valueOf(value.toUpperCase(Locale.ROOT));
    }

}
