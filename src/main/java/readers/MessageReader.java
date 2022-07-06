package readers;

import messages.fields.Field;
import messages.Message;
import strategies.messageSetters.*;

import java.io.IOException;

public class MessageReader {

    private FieldReader fieldReader;

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
            case ("text"):
                return new setText();
            case ("id"):
                return new setID();
            case ("date"):
                return new setDate();
            case ("from"):
                return new setFrom();
            case ("photo"):
                return new setPhotoPath();
            default:
                return new setNothing();
        }
    }
}
