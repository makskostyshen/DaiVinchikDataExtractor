package strategies.messageSetters;

import messages.fields.Field;
import messages.Message;

public class setNothing implements MessageSetter{
    @Override
    public void set(Message message, Field field){}
}
