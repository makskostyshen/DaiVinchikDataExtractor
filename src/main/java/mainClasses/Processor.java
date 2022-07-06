package mainClasses;

import messages.Message;
import readers.MessageReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    public List<Message> process() throws IOException {

        List<Message> messages = new ArrayList<>();

        MessageReader messageReader = new MessageReader(PATH_CONSTANTS.getJsonFilePath());
        messageReader.open();

        int counter = 0;
        while (messageReader.hasNextMessage()){
            Message newMessage = messageReader.getNextMessage();
            messages.add(newMessage);
            System.out.println(counter++);
        }

        messageReader.close();
        return messages;
    }

}

