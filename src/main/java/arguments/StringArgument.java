package arguments;


public class StringArgument implements Argument {

    private String value;

    public StringArgument(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
