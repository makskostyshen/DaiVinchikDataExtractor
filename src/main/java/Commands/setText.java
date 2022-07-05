package Commands;

import Additional.Message;
import arguments.Argument;

public class setText implements Command{

    @Override
    public void set(Message message, Argument argument) {
        message.setText((String) argument.getValue());
    }
}
