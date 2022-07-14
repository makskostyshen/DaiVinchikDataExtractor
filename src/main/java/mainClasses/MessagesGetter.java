package mainClasses;

import messages.Message;
import readers.MessageReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessagesGetter {

    public List<Message> getMessages() throws IOException {

        List<Message> messages = new ArrayList<>();

        MessageReader messageReader = new MessageReader(FILEPATH_CONSTANTS.getJsonFilePath());
        messageReader.open();

        while (messageReader.hasNextMessage()){
            Message newMessage = messageReader.getNextMessage();
            messages.add(newMessage);
        }

        messageReader.close();
        return messages;
    }

}

