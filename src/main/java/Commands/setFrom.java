package Commands;

import Additional.Message;
import arguments.Argument;

public class setFrom implements Command{
    @Override
    public void set(Message message, Argument argument) {
        message.setFrom((String) argument.getValue());
    }
}
