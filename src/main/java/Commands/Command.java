package Commands;

import Additional.Message;
import arguments.Argument;

public interface Command {
    void set(Message message, Argument argument);
}
