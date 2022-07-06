package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setID implements MessageSetter {
    @Override
    public void set(Message message, Field field) {
        message.setID((Integer) field.getValue());
    }
}
