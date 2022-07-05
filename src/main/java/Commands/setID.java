package Commands;

import Additional.Message;
import arguments.Argument;

public class setID implements Command{
    @Override
    public void set(Message message, Argument argument) {
        message.setID((Integer) argument.getValue());
    }
}
