package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setPhotoPath implements MessageSetter {
    @Override
    public void set(Message message, Field field) {
        message.setPhotoPath((String) field.getValue());
    }
}
