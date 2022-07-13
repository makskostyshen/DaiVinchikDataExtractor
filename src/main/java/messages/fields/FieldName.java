package messages.fields;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public enum FieldName {

    ID("id"),
    TYPE("type"),
    DATE("date"),
    FROM("from"),
    PHOTO("photo"),
    TEXT("text"),
    EMPTY("empty");


    private final String value;

    private static final Set<String> valuesSet = new HashSet<>(
            Arrays.stream(values())
                    .map(fieldName -> fieldName.getValue())
                    .collect(Collectors.toSet())
    );

    FieldName (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FieldName createFieldName(String value){

        if (valuesSet.contains(value)){
            return valueOf(value.toUpperCase(Locale.ROOT));
        }

        else return FieldName.EMPTY;
    }

}
