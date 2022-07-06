package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setText implements MessageSetter {

    @Override
    public void set(Message message, Field field) {
        message.setText((String) field.getValue());
    }
}
