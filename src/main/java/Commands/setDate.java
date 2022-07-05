package Commands;

import Additional.Message;
import arguments.Argument;

public class setDate implements Command{

    @Override
    public void set(Message message, Argument argument) {
        message.setDate((String) argument.getValue());
    }
}
