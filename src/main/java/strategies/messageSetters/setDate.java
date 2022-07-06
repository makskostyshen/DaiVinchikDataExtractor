package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setDate implements MessageSetter {

    @Override
    public void set(Message message, Field field) {
        message.setDate((String) field.getValue());
    }
}
