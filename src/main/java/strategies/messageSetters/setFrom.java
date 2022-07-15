package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setFrom implements MessageSetter {
    @Override
    public void set(Message message, Field field) {
        message.setSender((String) field.getValue());
    }
}
