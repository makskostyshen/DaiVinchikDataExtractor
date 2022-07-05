package arguments;

public class IntArgument implements Argument{
    private int value;

    public IntArgument(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
