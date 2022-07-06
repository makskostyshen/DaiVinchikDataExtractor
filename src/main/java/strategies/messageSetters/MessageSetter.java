package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public interface MessageSetter {
    void set(Message message, Field field);
}
