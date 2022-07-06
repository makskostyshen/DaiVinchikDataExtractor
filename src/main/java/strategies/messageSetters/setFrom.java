package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setFrom implements MessageSetter {
    @Override
    public void set(Message message, Field field) {
        message.setFrom((String) field.getValue());
    }
}
