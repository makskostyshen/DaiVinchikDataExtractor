package Commands;

import Additional.Message;
import arguments.Argument;

public class setPhotoPath implements Command{
    @Override
    public void set(Message message, Argument argument) {
        message.setPhotoPath((String) argument.getValue());
    }
}
