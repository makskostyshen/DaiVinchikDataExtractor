package readers;

import messages.fields.Field;
import messages.Message;
import strategies.messageSetters.*;

import java.io.IOException;

public class MessageReader {

    private final FieldReader fieldReader;

    public MessageReader(String filePath) throws IOException {
        this.fieldReader = new FieldReader(filePath);
    }

    public Message getNextMessage() throws IOException {
        fieldReader.beginMessage();    ///////

        Message message = new Message();

        while (fieldReader.hasNextField()) {
            Field field = fieldReader.getNextField();

            MessageSetter messageSetter = getSetter(field);

            messageSetter.set(message, field);
        }
        fieldReader.endMessage();

    return message;
    }


    public void open() throws IOException {
        fieldReader.readInitialFields();
    }


    public void close() throws IOException {
        fieldReader.readFinalFields();
    }


    public boolean hasNextMessage() throws IOException {
        return fieldReader.hasNextField();
    }


    private MessageSetter getSetter(Field field){

        switch (field.getName()){
            case TEXT:
                return new setText();
            case ID:
                return new setID();
            case DATE:
                return new setDate();
            case FROM:
                return new setFrom();
            case PHOTO:
                return new setPhotoPath();
            default:
                return new setNothing();
        }
    }
}
